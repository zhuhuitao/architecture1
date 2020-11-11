package com.huitao.architecture.viewmodel.brige.livedata

import androidx.lifecycle.MutableLiveData


/**
 * @author Frank
 * @date 2020/5/26.
 * email：zhuhuitao_struggle@163.com
 * description：自定义Int MutableLiveData 默认值为0 避免取值要进行判空操作
 */
class IntLiveData(value : Int = 0) : MutableLiveData<Int>(value) {
    override fun getValue(): Int? {
        return super.getValue()!!
    }
}