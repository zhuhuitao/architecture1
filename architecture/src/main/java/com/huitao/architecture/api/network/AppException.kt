package com.huitao.architecture.api.network

/**
 * @author Frank
 * @date 2020/5/27.
 * email：zhuhuitao_struggle@163.com
 * description：自定义错误异常
 */
class AppException : Exception {

    var errormsg: String //错误消息
    var errorCode: Int //错误码
    var errorLog: String? //错误日志

    constructor(errorCode: Int, error: String?, errorLog: String? = "") {
        this.errormsg = error ?: "请求失败，请稍后再试"
        this.errorCode = errorCode
        this.errorLog = errorLog
    }

    constructor(error: Error, e: Throwable?) {
        errorCode = error.getKey()
        errormsg = error.getValue()
        errorLog = e?.message
    }
}