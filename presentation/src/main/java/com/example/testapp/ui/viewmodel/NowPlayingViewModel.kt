package com.example.testapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entity.NetworkState
import com.example.domain.usecase.NowPlayingUseCase
import org.koin.core.KoinComponent
import org.koin.core.inject

class NowPlayingViewModel : ViewModel(), KoinComponent{


    private val nowPlayingUseCase: NowPlayingUseCase by inject()

    val refreshLiveDataState = MutableLiveData<NetworkState>()
    val initialLiveDataState = MutableLiveData<NetworkState>()

    val pagedListLiveData = nowPlayingUseCase.requestListData()

    fun requestInitialData() {
        nowPlayingUseCase.getNowPlayingPaged(null, initialLiveDataState)
    }

    fun refresh(){
        nowPlayingUseCase.refresh(refreshLiveDataState)
    }

}