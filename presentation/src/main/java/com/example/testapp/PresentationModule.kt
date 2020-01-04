package com.example.testapp

import com.example.domain.DomainModule
import com.example.testapp.ui.viewmodel.NowPlayingListViewModel
import com.example.testapp.ui.viewmodel.NowPlayingMovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { NowPlayingListViewModel()}
    viewModel { NowPlayingMovieViewModel() }
}

object PresentationModule {
    fun start(){
        loadKoinModules(viewModelsModule)
        DomainModule.start()
    }
}