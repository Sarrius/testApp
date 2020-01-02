package com.example.data

import com.example.data.database.DbManager
import com.example.remote.ApiModule
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val databaseModule = module {
    single { DbManager.getRoom(get(), "MoviesDb") }//TODO hardcoded DB name
}

val apiSourcesModule = module {
    single { DbManager.getRoom(get(), "MoviesDb") }//TODO hardcoded DB name
}

val dbSourcesModule = module {
    single { DbManager.getRoom(get(), "MoviesDb") }//TODO hardcoded DB name
}



object DataModule {

    fun start() {
        ApiModule.start()
        loadKoinModules(databaseModule, apiSourcesModule, dbSourcesModule)
    }
}
