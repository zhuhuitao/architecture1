package com.huitao.architecture.viewmodel.brige.livedata

import androidx.lifecycle.MutableLiveData


/**
 * @author Frank
 * @date 2020/5/26.
 * email：zhuhuitao_struggle@163.com
 * description：自定义Boolean MutableLiveData 提供默认值false，避免取值值要进行判空操作
 */
class BooleanLiveData(value: Boolean = false) : MutableLiveData<Boolean>(value) {
    override fun getValue(): Boolean? {
        return super.getValue()!!
    }
}