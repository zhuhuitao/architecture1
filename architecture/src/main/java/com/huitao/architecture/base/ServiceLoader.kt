package com.huitao.architecture.base

import java.util.ServiceLoader

/**
 *author  : Frank
 *e-mail  : zhuhuitao_struggle@163.com
 *date    : 2020/11/10 10:49
 *desc    : 服务加载
 *version :
 */
interface ServiceLoader {
    companion object {
        fun <S> load(service: Class<S>): S? {
            return try {
                ServiceLoader.load(service).iterator().next()
            } catch (e: Exception) {
                null
            }
        }
    }
}