package com.huitao.architecture.api.network

import android.app.Application

/**
 *author  : Frank
 *e-mail  : zhuhuitao_struggle@163.com
 *date    : 2020/11/4 16:59
 *desc    :
 *version :
 */
class ApiManager {
    companion object {
        lateinit var context: Application
    }

    fun initApi(context: Application) {
        Companion.context = context;
    }

}