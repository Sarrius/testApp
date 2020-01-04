package com.example.domain.usecase

import com.example.domain.entity.NowPlayingPosterModel

interface BoundaryCallbackListener {

    fun onZeroLoaded()
    fun onItemAtEndLoaded(itemAtEnd: NowPlayingPosterModel)
}