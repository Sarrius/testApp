package com.example.domain

import com.example.data.DataModule
import com.example.domain.usecase.NowPlayingListUseCase
import com.example.domain.usecase.NowPlayingMovieUseCase
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val useCaseModule = module {
    single { NowPlayingListUseCase(get()) }
    single { NowPlayingMovieUseCase(get()) }
}


object DomainModule {

    fun start() {
        loadKoinModules(useCaseModule)
        DataModule.start()
    }
}
