package com.huitao.architecture.base

import android.util.SparseArray
import androidx.lifecycle.ViewModel


/**
 * @author Frank
 * @date 2020/5/21.
 * email：zhuhuitao_struggle@163.com
 * description：安全模式，子类提供实例，父类处理业务，不向子类直接提供操作dataBinding实例，避免发生危险
 */
class DataBindingConfig(layout: Int, stateViewModel: BaseViewModel) {
    var layout: Int = 0

    var stateViewModel: ViewModel? = null

    var bindingParams = SparseArray<Any>()

    init {
        this.layout = layout
        this.stateViewModel = stateViewModel
    }

    public fun addBindParams(variableId: Int, any: Any): DataBindingConfig {
        if (bindingParams.get(variableId) == null) {
            bindingParams.put(variableId, any)
        }
        return this
    }

}