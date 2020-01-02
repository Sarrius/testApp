package com.example.domain

import com.example.data.DataModule
import com.example.data.repository.NowPlayingRepository
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val repoModule = module {
    single { NowPlayingRepository() }
}

object DomainModule {

    fun start() {
        DataModule.start()
        loadKoinModules(repoModule)
    }
}
