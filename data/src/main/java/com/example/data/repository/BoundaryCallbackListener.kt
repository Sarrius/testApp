package com.example.data.repository

import com.example.data.model.NowPlayingPosterModel

interface BoundaryCallbackListener {

    fun onZeroLoaded()
    fun onItemAtEndLoaded(itemAtEnd: NowPlayingPosterModel)
}