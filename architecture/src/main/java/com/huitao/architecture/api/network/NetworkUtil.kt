@file:Suppress("DEPRECATION", "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.huitao.architecture.api.network

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo


/**
 * @author Frank
 * @date 2020/5/26.
 * email：zhuhuitao_struggle@163.com
 * description：
 */
object NetworkUtil {

    /**
     * NetworkAvailable
     */
    val NET_CNNT_BAIDU_OK = 1

    /**
     * no NetworkAvailable
     */
    val NET_CNNT_BAIDU_TIMEOUT = 2

    /**
     * Net no ready
     */
    val NET_NOT_PREPARE = 3

    /**
     * net error
     */
    val NET_ERROR = 4

    /**
     * TIMEOUT
     */
    val TIMEOUT = 3000



    @SuppressLint("MissingPermission")
    fun isNetworkAvailable(context: Context): Boolean {
        val manager: ConnectivityManager =
            context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                ?: return false
        val info: NetworkInfo = manager.activeNetworkInfo ?: return false
        if (!info.isAvailable) return false
        return true
    }
}