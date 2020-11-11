package com.huitao.architecture.api.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


/**
 * @author Frank
 * @date 2020/5/27.
 * email：zhuhuitao_struggle@163.com
 * description：添加请求头
 */
open class HeadInterceptor : Interceptor {
    private var headers: Map<String, String>?

    init {
        headers = this.createInterceptor()
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        if (headers != null && headers!!.isNotEmpty()) {
            val keys = headers!!.keys
            for (headerKey in keys) {
                headers!![headerKey]?.let {
                    builder.addHeader(headerKey, it).build()
                }
            }
        }
        return chain.proceed(builder.build())
    }


     open fun createInterceptor(): Map<String, String>? {
        return null
    }


}