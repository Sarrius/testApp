package com.example.domain.usecase.boundary

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.example.domain.entity.NetworkState
import com.example.domain.entity.NowPlayingMovieModel

class NowPlayingBoundaryCallback(
    private val networkState: MutableLiveData<NetworkState>,
    private val onboundarycallbackListener: BoundaryCallbackListener
) : PagedList.BoundaryCallback<NowPlayingMovieModel>() {

    override fun onZeroItemsLoaded() {
        onboundarycallbackListener.onZeroLoaded()
    }

    override fun onItemAtEndLoaded(itemAtEnd: NowPlayingMovieModel) {
        networkState.value = NetworkState.PROGRESS
        onboundarycallbackListener.onItemAtEndLoaded(itemAtEnd, networkState)
    }
}