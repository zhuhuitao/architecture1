package com.huitao.architecture.base

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.huitao.architecture.R
import com.xionggouba.architecture.base.BaseVmDbActivity
import com.xionggouba.architecture.getString

interface IBaseVmDbView {

    fun showLoading(msg: String)

    fun dismissDialog()

    fun showShortToast(msg: String)

    fun showLongToast(msg: String)

    fun <VM : BaseViewModel> createViewModel(): VM

    fun <RM : BaseViewModel> createRequestViewModel(): RM

    fun <T : BaseVmDbActivity<*, *>> startActivity(clazz: Class<T>)

    fun <T : BaseVmDbActivity<*, *>> startActivity(clazz: Class<T>, bundle: Bundle?)

    fun registerDefaultUiChange(viewModel: BaseViewModel, owner: LifecycleOwner) {
        viewModel.UiLoadingUiChange().showLoading.observe(owner, Observer {
            if (it.isEmpty()) {
                showLoading(getString(R.string.requesting))
            } else {
                showLoading(it)
            }
        })
        viewModel.UiLoadingUiChange().dismissLoading.observe(owner, Observer {
            dismissDialog()
        })
    }

    fun observerNetworkChange(owner: LifecycleOwner) {
       /* NetworkStateManager.instant.mNetworkStateCallback.observe(owner, Observer {
            onNetworkChanged()
        })*/
    }

}