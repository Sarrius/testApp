package com.example.domain

import com.example.data.DataModule
import com.example.domain.usecase.NowPlayingUseCase
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val useCaseModule = module {
    single { NowPlayingUseCase(get()) }
}


object DomainModule {

    fun start() {
        loadKoinModules(useCaseModule)
        DataModule.start()
    }
}
