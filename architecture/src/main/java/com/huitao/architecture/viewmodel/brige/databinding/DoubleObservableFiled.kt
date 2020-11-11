package com.huitao.architecture.viewmodel.brige.databinding

import androidx.databinding.ObservableField


/**
 * @author Frank
 * @date 2020/5/26.
 * email：zhuhuitao_struggle@163.com
 * description：自定义Double ObservableField 默认值0.0 避免取值判空
 */
class DoubleObservableFiled(value : Double = 0.0) : ObservableField<Double>(value) {
    override fun get(): Double? {
        return super.get()!!
    }
}