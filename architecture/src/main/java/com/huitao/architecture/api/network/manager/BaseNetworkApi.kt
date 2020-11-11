package com.huitao.architecture.api.network.manager

import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 *author  : Frank
 *e-mail  : zhuhuitao_struggle@163.com
 *date    : 2020/11/4 11:18
 *desc    :
 *version : 构造网络请求
 */
abstract class BaseNetworkApi {
    private lateinit var builder: OkHttpClient.Builder
    fun <T> getApi(serviceClass: Class<T>, baseUrl: String): T {
        val retrofitBuilder: Retrofit.Builder =
            Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient)
        return setRetrofitBuilder(retrofitBuilder).build().create(serviceClass)
    }


    //todo 由子类拓展  对okHttp进行定制 比如 添加拦截器等等
    abstract fun setOkHttpClintBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder

    //todo 由子类自由拓展 对retrofit进行定制 比如添加son解析器
    abstract fun setRetrofitBuilder(builder: Retrofit.Builder): Retrofit.Builder

    private val okHttpClient: OkHttpClient
        get() {
            builder = OkHttpClient.Builder()
            builder = setOkHttpClintBuilder(builder)
            return builder.build()
        }

}