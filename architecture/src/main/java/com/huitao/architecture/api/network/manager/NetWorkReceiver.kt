package com.huitao.architecture.api.network.manager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast
import com.huitao.architecture.api.network.NetworkUtil

/**
 *author  : Frank
 *e-mail  : zhuhuitao_struggle@163.com
 *date    : 2020/11/3 10:39
 *desc    :
 *version :
 */
class NetWorkReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == ConnectivityManager.CONNECTIVITY_ACTION) {
            if (!NetworkUtil.isNetworkAvailable(context!!)) {
                //收到没有网络时判断之前的值是不是有网络，如果有网络才提示通知 ，防止重复通知
                NetworkStateManager.instant.mNetworkStateCallback.value?.let {
                    if (it.isSuccess) {
                        Toast.makeText(context, "网络不给力哦", Toast.LENGTH_SHORT).show()
                        NetworkStateManager.instant.mNetworkStateCallback.postValue(
                            NetState(
                                isSuccess = false
                            )
                        )
                    }
                }
            } else {
                //收到有网络时先判断之前是否有网络，没网络才发送通知，避免重复通知
                NetworkStateManager.instant.mNetworkStateCallback.value?.let {
                    if (!it.isSuccess) {
                        NetworkStateManager.instant.mNetworkStateCallback.postValue(
                            NetState(
                                isSuccess = true
                            )
                        )
                    }
                }
            }
        }
    }
}