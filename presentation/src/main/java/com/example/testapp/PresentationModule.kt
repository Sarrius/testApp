package com.example.testapp

import com.example.testapp.ui.viewmodel.NowPlayingViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {NowPlayingViewModel()}
}
