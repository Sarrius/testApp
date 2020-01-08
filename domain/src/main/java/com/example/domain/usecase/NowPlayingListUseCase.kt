package com.example.domain.usecase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.common.utils.Constants
import com.example.domain.entity.Listing
import com.example.data.repository.NowPlayingRepository
import com.example.domain.entity.NetworkState
import com.example.domain.entity.NowPlayingMovieModel
import com.example.domain.usecase.boundary.BoundaryCallbackListener
import com.example.domain.usecase.boundary.NowPlayingBoundaryCallback
import io.reactivex.rxkotlin.addTo
import mapToEntity
import timber.log.Timber

class NowPlayingListUseCase(
    private val nowPlayingRepository: NowPlayingRepository
) : BaseUseCase(nowPlayingRepository), BoundaryCallbackListener {

    fun refresh(networkState: MutableLiveData<NetworkState>) {
        networkState.value = NetworkState.PROGRESS
        nowPlayingRepository.refresh()
            .handleNetworkState(networkState)
            .addTo(compositeDisposable)
    }

    fun requestListData(nextPageState: MutableLiveData<NetworkState>,
                        initialLiveDataState: MutableLiveData<NetworkState>
    ): LiveData<PagedList<NowPlayingMovieModel>> {
        return LivePagedListBuilder(
            nowPlayingRepository.requestListData().map { it.mapToEntity() }
            , Constants.pageSize
        ).setBoundaryCallback(
            NowPlayingBoundaryCallback(
                initialLiveDataState,
                nextPageState,
                this
            )
        ).build()
    }

    override fun onZeroLoaded(
        networkState: MutableLiveData<NetworkState>
    ) {
        Timber.log(Log.DEBUG, "onZeroLoaded")

        networkState.value = NetworkState.PROGRESS
        nowPlayingRepository.getNowPlayingPaged(null)
            .handleNetworkState(networkState)
            .addTo(compositeDisposable)
    }

    override fun onItemAtEndLoaded(
        itemAtEnd: NowPlayingMovieModel,
        networkState: MutableLiveData<NetworkState>
    ) {
        Timber.log(Log.DEBUG, "***************onItemAtEndLoaded*********")
        Timber.log(Log.DEBUG, "itemAtEnd " + itemAtEnd.id)

        nowPlayingRepository.getNowPlayingPaged(itemAtEnd.nextPage)
            .handleNetworkState(networkState)
            .addTo(compositeDisposable)
    }
}


