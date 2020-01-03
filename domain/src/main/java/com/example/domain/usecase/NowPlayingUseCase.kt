package com.example.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.data.model.Listing
import com.example.data.model.NowPlayingPosterModel
import com.example.data.repository.NowPlayingRepository
import com.example.domain.entity.NetworkState
import io.reactivex.rxkotlin.addTo

class NowPlayingUseCase(
    private val nowPlayingRepository: NowPlayingRepository
): BaseUseCase(nowPlayingRepository){

    override fun refresh(networkState: MutableLiveData<NetworkState>){
        nowPlayingRepository.refresh()
            .handleState(networkState)
            .addTo(compositeDisposable)

    }

    fun getNowPlayingPaged(page: Int?, networkState: MutableLiveData<NetworkState>){
        nowPlayingRepository.getNowPlayingPaged(page)
            .handleState(networkState)
    }

    fun getNowPlayingById(id: Int){
        nowPlayingRepository.getNowPlayingById(id)
    }

    fun requestListData(): Listing<NowPlayingPosterModel> {
       return Listing(nowPlayingRepository.requestListData())
    }
}


