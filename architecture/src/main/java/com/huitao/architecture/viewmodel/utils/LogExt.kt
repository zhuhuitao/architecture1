package com.huitao.architecture.viewmodel.utils

import android.util.Log
import androidx.viewbinding.BuildConfig


/**
 * @author Frank
 * @date 2020/5/27.
 * email：zhuhuitao_struggle@163.com
 * description：日志输出
 */

const val TAG = "Frank"

var showLog: Boolean = BuildConfig.DEBUG

private enum class LEVEL {
    V, D, I, W, E
}

fun String.logv(tag: String = TAG) =
    log(LEVEL.V, tag, this)

fun String.logd(tag: String = TAG) =
    log(LEVEL.D, tag, this)

fun String.logi(tag: String = TAG) =
    log(LEVEL.I, tag, this)

fun String.logw(tag: String = TAG) =
    log(LEVEL.W, tag, this)

fun String.loge(tag: String = TAG) =
    log(LEVEL.E, tag, this)

private fun log(level: LEVEL, tag: String, message: String) {
    if (!showLog) return
    when (level) {
        LEVEL.V -> Log.v(tag, message)
        LEVEL.D -> Log.d(tag, message)
        LEVEL.I -> Log.i(tag, message)
        LEVEL.W -> Log.w(tag, message)
        LEVEL.E -> Log.e(tag, message)
    }
}