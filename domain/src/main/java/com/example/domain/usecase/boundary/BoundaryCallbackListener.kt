package com.example.domain.usecase.boundary

import androidx.lifecycle.MutableLiveData
import com.example.domain.entity.NetworkState
import com.example.domain.entity.NowPlayingMovieModel

interface BoundaryCallbackListener {

    fun onZeroLoaded(networkState: MutableLiveData<NetworkState>)
    fun onItemAtEndLoaded(itemAtEnd: NowPlayingMovieModel,
                          networkState: MutableLiveData<NetworkState>)
}