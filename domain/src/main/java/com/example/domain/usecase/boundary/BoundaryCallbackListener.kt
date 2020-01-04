package com.example.domain.usecase.boundary

import com.example.domain.entity.NowPlayingMovieModel

interface BoundaryCallbackListener {

    fun onZeroLoaded()
    fun onItemAtEndLoaded(itemAtEnd: NowPlayingMovieModel)
}