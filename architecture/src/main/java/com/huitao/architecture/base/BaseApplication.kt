package com.huitao.architecture.base

import android.app.Application
import android.content.Context
open class BaseApplication : Application() {
    lateinit var mContext: Context

    companion object {
        val instance by lazy { BaseApplication() }
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
    }

}