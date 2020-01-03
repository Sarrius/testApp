package com.example.data

import com.example.data.database.DbManager
import com.example.data.repository.NowPlayingRepository
import com.example.data.repository.datasource.api.NowPlayingApiDataSource
import com.example.data.repository.datasource.local.NowPlayingDbDataSource
import com.example.remote.ApiModule
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val databaseModule = module {
    single { DbManager.getRoom(get(), "MoviesDb") }//TODO hardcoded DB name
}

val repositoryModule = module {
    single { NowPlayingRepository(get(), get()) }
}

val apiSourcesModule = module {
    single { NowPlayingApiDataSource(get(), get()) }
}

val dbSourcesModule = module {
    single { NowPlayingDbDataSource() }
}

object DataModule {

    fun start() {
        loadKoinModules(
            databaseModule,
            repositoryModule,
            apiSourcesModule,
            dbSourcesModule
        )
        ApiModule.start()
    }
}
