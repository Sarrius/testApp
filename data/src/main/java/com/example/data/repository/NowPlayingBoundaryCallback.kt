package com.example.data.repository

import androidx.paging.PagedList
import com.example.data.model.NowPlayingPosterModel

class NowPlayingBoundaryCallback(private val onboundarycallbackListener: BoundaryCallbackListener) : PagedList.BoundaryCallback<NowPlayingPosterModel>(){

    override fun onZeroItemsLoaded() {
        onboundarycallbackListener.onZeroLoaded()
    }

    override fun onItemAtEndLoaded(itemAtEnd: NowPlayingPosterModel) {
        onboundarycallbackListener.onItemAtEndLoaded(itemAtEnd)
    }
}