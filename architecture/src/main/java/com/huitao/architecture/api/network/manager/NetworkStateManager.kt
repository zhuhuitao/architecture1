package com.huitao.architecture.api.network.manager

import com.huitao.architecture.viewmodel.brige.livedata.UnPeekLiveData


/**
 *author  : Frank
 *e-mail  : zhuhuitao_struggle@163.com
 *date    : 2020/11/3 10:22
 *desc    :
 *version :
 */
class NetworkStateManager {
    val mNetworkStateCallback = UnPeekLiveData<NetState>()

    init {
        //TODO  值为空 或者 没有网络的时候才能初始化设置网络
        if (mNetworkStateCallback.value == null || !mNetworkStateCallback.value!!.isSuccess) {
            mNetworkStateCallback.postValue(NetState(isSuccess = true))
        }
    }

    companion object {
        val instant: NetworkStateManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            NetworkStateManager()
        }
    }
}

