package com.example.testapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.NowPlayingUseCase
import org.koin.core.KoinComponent
import org.koin.core.inject

class NowPlayingViewModel : ViewModel(), KoinComponent{

    val nowPlayingUseCase: NowPlayingUseCase by inject()

    fun requestInitialData() {
        nowPlayingUseCase.getNowPlayingPaged(null)
    }
}