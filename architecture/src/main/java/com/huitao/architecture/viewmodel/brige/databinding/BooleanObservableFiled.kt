package com.huitao.architecture.viewmodel.brige.databinding

import androidx.databinding.ObservableField


/**
 * @author Frank
 * @date 2020/5/26.
 * email：zhuhuitao_struggle@163.com
 * description：自定义 Boolean ObservableField 默认为false 避免取值判空
 */
class BooleanObservableFiled(value: Boolean = false) : ObservableField<Boolean>(value) {
    override fun get(): Boolean? {
        return super.get()!!
    }
}