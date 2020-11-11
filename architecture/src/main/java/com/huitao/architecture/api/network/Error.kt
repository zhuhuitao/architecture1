package com.huitao.architecture.api.network


/**
 * @author Frank
 * @date 2020/5/27.
 * email：zhuhuitao_struggle@163.com
 * description：错误枚举类
 */

enum class Error(private val code: Int, private val err: String) {
    /**
     * 未知错误
     */
    UNKNOWN(1000, "请求失败，请稍后再试"),

    /**
     * 解析错误
     */
    PARSE_ERROR(1001, "解析错误，请稍后再试"),

    /**
     * 网络错误
     */
    NETWORD_ERROR(1002, "网络连接错误，请稍后重试"),

    /**
     * 证书出错
     */
    SSL_ERROR(1004, "证书出错，请稍后再试"),

    /**
     * 连接超时
     */
    TIMEOUT_ERROR(1006, "网络连接超时，请稍后重试"),

    /**
     * 登录过期
     */
    LOGIN_EXPIRED(401, "TOKEN 失效"),

    /**
     * 登录失效  三方登录情况
     */
    LOGIN_FAILURE(402, "登录失效"),

    /**
     * 短信次数达到上限
     */
    PHONE_MSG_MAX_LIMIT(10008, "发送短信次数已达上限"),

    /**
     * 密码输入次数达到最大值
     */
    LOGIN_PASSWORD_MAX(10005, "密码输入次数达到最大值");


    fun getValue(): String {
        return err
    }

    fun getKey(): Int {
        return code
    }

}