package com.xionggouba.architecture.base

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.huitao.architecture.base.BaseViewModel
import com.huitao.architecture.base.IBaseVmDbView

abstract class BaseVmDbActivity<VM : BaseViewModel, RM : BaseViewModel>
    : AppCompatActivity(), IBaseVmDbView {

    //TODO 声明viewModel 由子类创建使用

    lateinit var mViewModel: VM;

    lateinit var mRequestViewModel: RM;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = createViewModel()
        mRequestViewModel = createRequestViewModel()
        registerDefaultUiChange(mViewModel, this)
        observerNetworkChange(this)
    }

    override fun showLongToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }


    override fun showShortToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


    override fun <T : BaseVmDbActivity<*, *>> startActivity(clazz: Class<T>) {
        startActivity(clazz, null)
    }

    override fun <T : BaseVmDbActivity<*, *>> startActivity(clazz: Class<T>, bundle: Bundle?) {
        val intent = Intent(this, clazz)
        startActivity(intent, bundle)
    }


}