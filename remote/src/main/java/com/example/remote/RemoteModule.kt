package com.example.remote

import com.example.common.utils.ServiceUtil
import com.example.remote.interceptors.QueryParamInterceptor
import com.example.remote.managers.MovieApiManager
import com.example.remote.service.MoviesService
import org.koin.core.KoinComponent
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val serviceModule = module {
    single { ApiModule.provideService() }
}

val managersModule = module {
    single { MovieApiManager(moviesService = get(), applicationContext = get()) }
}

object ApiModule : KoinComponent {

    fun start() {
        loadKoinModules(
            managersModule, serviceModule
        )
    }

    fun provideService(): MoviesService {
        return ServiceUtil.buildRetrofit(
            "baseurl",
            MoviesService::class.java,
            QueryParamInterceptor(HashMap<String, String>().apply {
                put("api_key", "1f71bb7ac9eb935e91dad65b12b18354")
            }))//TODO hardcoded query params
    }

}
