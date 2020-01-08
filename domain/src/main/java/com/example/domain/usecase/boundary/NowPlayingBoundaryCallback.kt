package com.example.domain.usecase.boundary

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.example.domain.entity.NetworkState
import com.example.domain.entity.NowPlayingMovieModel
import timber.log.Timber

class NowPlayingBoundaryCallback(
    private val initialLiveDataState: MutableLiveData<NetworkState>,
    private val networkState: MutableLiveData<NetworkState>,
    private val onboundarycallbackListener: BoundaryCallbackListener
) : PagedList.BoundaryCallback<NowPlayingMovieModel>() {


    override fun onZeroItemsLoaded() {

        Timber.log(Log.DEBUG, Thread.currentThread().name)
        Timber.log(Log.DEBUG, "onZeroItemsLoaded")
        initialLiveDataState.value = NetworkState.PROGRESS
        onboundarycallbackListener.onZeroLoaded(networkState)
    }

    override fun onItemAtEndLoaded(itemAtEnd: NowPlayingMovieModel) {
        Timber.log(Log.DEBUG, Thread.currentThread().name)
        Timber.log(Log.DEBUG, "onItemAtEndLoaded = $itemAtEnd")
        networkState.value = NetworkState.PROGRESS
        onboundarycallbackListener.onItemAtEndLoaded(itemAtEnd, networkState)
    }
}