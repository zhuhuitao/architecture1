package com.huitao.architecture.viewmodel.brige.databinding

import androidx.databinding.ObservableField


/**
 * @author Frank
 * @date 2020/5/26.
 * email：zhuhuitao_struggle@163.com
 * description：自定义Int ObservableField 默认值为0 避免取值判空
 */
class IntObservableFiled(value : Int = 0) : ObservableField<Int>(value) {
    override fun get(): Int? {
        return super.get()!!
    }
}