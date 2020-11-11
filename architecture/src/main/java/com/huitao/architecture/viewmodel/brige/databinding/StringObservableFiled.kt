package com.huitao.architecture.viewmodel.brige.databinding

import androidx.databinding.ObservableField


/**
 * @author Frank
 * @date 2020/5/26.
 * email：zhuhuitao_struggle@163.com
 * description：自定义String ObservableField 默认值为"" 避免取值判空
 */
class StringObservableFiled(value: String = "") : ObservableField<String>(value) {
    override fun get(): String? {
        return super.get()!!
    }
}