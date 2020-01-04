package com.example.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.data.repository.NowPlayingRepository
import com.example.domain.entity.NetworkState
import com.example.domain.entity.NowPlayingMovieModel
import com.example.domain.usecase.boundary.BoundaryCallbackListener
import com.example.domain.usecase.boundary.NowPlayingBoundaryCallback
import io.reactivex.rxkotlin.addTo
import mapToEntity

class NowPlayingListUseCase(
    private val nowPlayingRepository: NowPlayingRepository
): BaseUseCase(nowPlayingRepository), BoundaryCallbackListener {

    fun refresh(networkState: MutableLiveData<NetworkState>){
        nowPlayingRepository.refresh()
            .handleNetworkState(networkState)
            .addTo(compositeDisposable)
    }

    fun getNowPlayingPaged(page: Int?, networkState: MutableLiveData<NetworkState>){
        nowPlayingRepository.getNowPlayingPaged(page)
            .handleNetworkState(networkState)
            .addTo(compositeDisposable)
    }

    fun requestListData(): LiveData<PagedList<NowPlayingMovieModel>> {
        return LivePagedListBuilder(
            nowPlayingRepository.requestListData().map { it.mapToEntity() }
            , 20
        ).setBoundaryCallback(NowPlayingBoundaryCallback(this))
            .build() //TODO nextPage size configurable val
    }

    override fun onZeroLoaded() {

    }

    override fun onItemAtEndLoaded(itemAtEnd: NowPlayingMovieModel) {
        nowPlayingRepository.getNowPlayingPaged(itemAtEnd.nextPage)
            .handleNetworkState(null)
            .addTo(compositeDisposable)
    }
}


