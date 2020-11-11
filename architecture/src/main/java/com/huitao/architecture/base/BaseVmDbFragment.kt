package com.huitao.architecture.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.xionggouba.architecture.base.BaseVmDbActivity

abstract class BaseVmDbFragment<VM : BaseViewModel, RM : BaseViewModel> : Fragment(),
    IBaseVmDbView {
    //TODO 声明viewModel 由子类创建使用
    lateinit var mViewModel: VM;
    lateinit var mRequestViewModel: RM
    private var mIsFirst: Boolean = true
    var mIsNavigationViewInit = false

    abstract fun lazyLoadData()

    abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = createViewModel()
        mRequestViewModel = createRequestViewModel()
        registerDefaultUiChange(mViewModel, this)
        observerNetworkChange(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return onCreateMyView(inflater, container, savedInstanceState)
    }

    abstract fun onCreateMyView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!mIsNavigationViewInit) {
            observerNetworkChange(this)
            onVisible()
            init()
            mIsNavigationViewInit = true
        }
    }

    override fun onResume() {
        super.onResume()
        onVisible()
    }

    private fun onVisible() {
        if (lifecycle.currentState == Lifecycle.State.STARTED && mIsFirst) {
            mIsFirst = false
            lazyLoadData()
        }
    }

    override fun showLongToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }


    override fun showShortToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }


    override fun <T : BaseVmDbActivity<*, *>> startActivity(clazz: Class<T>) {
        startActivity(clazz, null)
    }

    override fun <T : BaseVmDbActivity<*, *>> startActivity(clazz: Class<T>, bundle: Bundle?) {
        val intent = Intent(context, clazz)
        startActivity(intent, bundle)
    }


}