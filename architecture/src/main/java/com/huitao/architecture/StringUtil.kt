package com.xionggouba.architecture

import com.huitao.architecture.base.BaseApplication

fun getString(id: Int): String {
    return BaseApplication.instance.getString(id)
}