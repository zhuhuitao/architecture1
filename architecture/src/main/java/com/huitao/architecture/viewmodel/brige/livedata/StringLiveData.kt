package com.huitao.architecture.viewmodel.brige.livedata

import androidx.lifecycle.MutableLiveData


/**
 * @author Frank
 * @date 2020/5/26.
 * email：zhuhuitao_struggle@163.com
 * description：自定义String MutableLiveData 默认值为"" 避免取值要判空
 */
class StringLiveData(value : String = "") : MutableLiveData<String>(value) {
    override fun getValue(): String? {
        return super.getValue()!!
    }
}