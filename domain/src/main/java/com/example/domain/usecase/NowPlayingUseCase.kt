package com.example.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.data.repository.NowPlayingRepository
import com.example.domain.entity.NetworkState
import com.example.domain.entity.NowPlayingPosterModel
import io.reactivex.rxkotlin.addTo
import mapToEntity

class NowPlayingUseCase(
    private val nowPlayingRepository: NowPlayingRepository
): BaseUseCase(nowPlayingRepository), BoundaryCallbackListener {

    override fun refresh(networkState: MutableLiveData<NetworkState>){
        nowPlayingRepository.refresh()
            .handleState(networkState)
            .addTo(compositeDisposable)
    }

    fun getNowPlayingPaged(page: Int?, networkState: MutableLiveData<NetworkState>){
        nowPlayingRepository.getNowPlayingPaged(page)
            .handleState(networkState)
            .addTo(compositeDisposable)
    }

    fun getNowPlayingById(id: Int){
        nowPlayingRepository.getNowPlayingById(id)
    }

    fun requestListData(): LiveData<PagedList<NowPlayingPosterModel>> {
        return LivePagedListBuilder(
            nowPlayingRepository.requestListData().map { it.mapToEntity() }
            , 20
        ).setBoundaryCallback(NowPlayingBoundaryCallback(this))
            .build() //TODO nextPage size configurable val
    }

    override fun onZeroLoaded() {

    }

    override fun onItemAtEndLoaded(itemAtEnd: NowPlayingPosterModel) {
        nowPlayingRepository.getNowPlayingPaged(itemAtEnd.nextPage)
            .handleState(null)
            .addTo(compositeDisposable)
    }
}


