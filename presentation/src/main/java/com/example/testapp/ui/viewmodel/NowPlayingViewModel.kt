package com.example.testapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entity.NetworkState
import com.example.domain.usecase.NowPlayingUseCase
import org.koin.core.KoinComponent
import org.koin.core.inject

class NowPlayingViewModel : ViewModel(), KoinComponent{

    private val nowPlayingUseCase: NowPlayingUseCase by inject()

    val refreshLiveData = MutableLiveData<NetworkState>()
    val initialLiveDate = MutableLiveData<NetworkState>()

    fun requestInitialData() {
        nowPlayingUseCase.getNowPlayingPaged(null, initialLiveDate)
    }

    fun refresh(){
        nowPlayingUseCase.refresh(refreshLiveData)
    }

}