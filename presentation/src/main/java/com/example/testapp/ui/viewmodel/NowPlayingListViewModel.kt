package com.example.testapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entity.NetworkState
import com.example.domain.entity.NowPlayingMovieModel
import com.example.domain.usecase.NowPlayingListUseCase
import org.koin.core.KoinComponent
import org.koin.core.inject

class NowPlayingListViewModel : ViewModel(), KoinComponent {


    private val nowPlayingListUseCase: NowPlayingListUseCase by inject()

    val refreshLiveDataState = MutableLiveData<NetworkState>()
    val initialLiveDataState = MutableLiveData<NetworkState>()
    val nextPageState = MutableLiveData<NetworkState>()
    var pagedListLiveData = nowPlayingListUseCase.requestListData(nextPageState, initialLiveDataState)

    fun refresh() {
        nowPlayingListUseCase.refresh(refreshLiveDataState)
    }
}
