package com.huitao.architecture.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.huitao.architecture.viewmodel.utils.SingleLiveEvent

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    val loadingUiChange by lazy {
        UiLoadingUiChange()
    }

    inner class UiLoadingUiChange {
        val showLoading by lazy { SingleLiveEvent<String>() }
        val dismissLoading by lazy { SingleLiveEvent<String>() }
    }
}