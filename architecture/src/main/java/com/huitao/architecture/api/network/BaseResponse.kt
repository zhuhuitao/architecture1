package com.huitao.architecture.api.network


/**
 * @author Frank
 * @date 2020/5/27.
 * email：zhuhuitao_struggle@163.com
 * description: 1, 服务器返回数据的基类 2， 必须实现抽象方法
 */
abstract class BaseResponse<T> {
    //继承它时 必须实现抽象方法
    abstract fun isSuccess(): Boolean

    abstract fun getResponseData(): T

    abstract fun getResponseCode(): Int

    abstract fun getResponseMsg(): String
}