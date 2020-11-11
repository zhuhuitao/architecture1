package com.huitao.architecture.api.network

import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.google.gson.GsonBuilder
import com.huitao.architecture.api.interceptor.CacheInterceptor
import com.huitao.architecture.api.interceptor.HeadInterceptor
import com.huitao.architecture.api.interceptor.logging.LogInterceptor
import com.huitao.architecture.api.network.manager.BaseNetworkApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 *author  : Frank
 *e-mail  : zhuhuitao_struggle@163.com
 *date    : 2020/11/4 16:18
 *desc    : retrofit okHttp apiService 创建
 *version :
 */
class NetworkApi : BaseNetworkApi() {

    companion object {
        val instance: NetworkApi by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            NetworkApi()
        }
    }

    fun <T> createService(service: Class<T>): T {
        return getApi(service, "")
    }

    override fun setOkHttpClintBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        builder.apply {
            //设置缓存配置 缓存最大10M
            cache(Cache(File(ApiManager.context.cacheDir, "zb_cache"), 10 * 1024 * 1024))
            //添加Cookies自动持久化
            cookieJar(cookieJar)
            //添加公共heads 注意要设置在日志拦截器之前，不然Log中会不显示head信息
            addInterceptor(HeadInterceptor())
            addInterceptor(CacheInterceptor())
            addInterceptor(LogInterceptor())
            connectTimeout(10, TimeUnit.SECONDS)
            readTimeout(5, TimeUnit.SECONDS)
            writeTimeout(5, TimeUnit.SECONDS)
        }
        return builder
    }

    override fun setRetrofitBuilder(builder: Retrofit.Builder): Retrofit.Builder {
        return builder.apply {
            addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            addCallAdapterFactory(CallAdapterFactory())
        }
    }

    private val cookieJar: PersistentCookieJar by lazy {
        PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(ApiManager.context))
    }
}