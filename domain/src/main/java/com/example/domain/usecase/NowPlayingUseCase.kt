package com.example.domain.usecase

import com.example.data.repository.NowPlayingRepository

class NowPlayingUseCase(private val nowPlayingRepository: NowPlayingRepository){

    fun getNowPlaying(page: Int){
        nowPlayingRepository.getNowPlaying(page)
    }
}