package com.example.testapp

import com.example.domain.DomainModule
import com.example.testapp.ui.viewmodel.NowPlayingViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {NowPlayingViewModel()}
}

object PresentationModule {
    fun start(){
        DomainModule.start()
    }
}