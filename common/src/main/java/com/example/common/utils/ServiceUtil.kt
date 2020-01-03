package com.example.common.utils

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceUtil {

    fun <T> buildRetrofit(url: String,
                          clazz: Class<T>,
                          vararg interceptors: Interceptor?): T {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(getOkHttpClient(*interceptors))
            .baseUrl(url)
            .build()
            .create(clazz)
    }

    fun getOkHttpClient(vararg interceptors: Interceptor?): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.MINUTES)

        interceptors.map { interceptor -> interceptor?.let { builder.addInterceptor(it)  } }

        return builder.build()
    }
}
