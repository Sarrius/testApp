package com.example.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class QueryParamInterceptor(private val queryParams: HashMap<String, String>) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        var buildr = originalHttpUrl.newBuilder()

        queryParams.map {
            buildr = buildr.addQueryParameter(it.key, it.value)
        }

        val requestBuilder = original.newBuilder()
            .url(buildr.build())

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}