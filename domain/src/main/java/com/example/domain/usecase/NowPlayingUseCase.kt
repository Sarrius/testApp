package com.example.domain.usecase

import com.example.data.model.Listing
import com.example.data.model.NowPlayingPosterModel
import com.example.data.repository.NowPlayingRepository

class NowPlayingUseCase(private val nowPlayingRepository: NowPlayingRepository): BaseUseCase(nowPlayingRepository){

    override fun refresh() {
        nowPlayingRepository.refresh()
    }

    fun getNowPlayingPaged(page: Int?){
        nowPlayingRepository.getNowPlayingPaged(page)
    }

    fun getNowPlayingById(id: Int){
        nowPlayingRepository.getNowPlayingById(id)
    }

    fun requestListData(): Listing<NowPlayingPosterModel> {
       return Listing(nowPlayingRepository.requestListData())
    }
}