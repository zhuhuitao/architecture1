package com.huitao.architecture.base

import androidx.databinding.ViewDataBinding

/**
 *author  : Frank
 *e-mail  : zhuhuitao_struggle@163.com
 *date    : 2020/11/3 15:56
 *desc    : activity 和 fragment 公共方法抽取
 *version :
 */
interface IInitialization {
    fun initViews()

    fun initData()

    fun createObserver()


    //TODO 警惕使用。非必要情况下，尽可能不在子类中拿到 binding 实例乃至获取 view 实例
    fun getBind(): ViewDataBinding

    fun getDataBindingConfig(): DataBindingConfig
}