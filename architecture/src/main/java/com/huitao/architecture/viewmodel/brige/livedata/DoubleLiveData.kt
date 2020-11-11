package com.huitao.architecture.viewmodel.brige.livedata

import androidx.lifecycle.MutableLiveData


/**
 * @author Frank
 * @date 2020/5/26.
 * email：zhuhuitao_struggle@163.com
 * description：自定义的Double类型 MutableLiveData 提供默认值0.0，避免取值的时候要进行判空操作
 */
class DoubleLiveData(value: Double = 0.0) : MutableLiveData<Double>(value) {
    override fun getValue(): Double? {
        return super.getValue()!!
    }
}