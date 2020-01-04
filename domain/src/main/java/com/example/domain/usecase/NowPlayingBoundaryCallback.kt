package com.example.domain.usecase

import androidx.paging.PagedList
import com.example.domain.entity.NowPlayingPosterModel

class NowPlayingBoundaryCallback(private val onboundarycallbackListener: BoundaryCallbackListener
) : PagedList.BoundaryCallback<NowPlayingPosterModel>(){

    override fun onZeroItemsLoaded() {
        onboundarycallbackListener.onZeroLoaded()
    }

    override fun onItemAtEndLoaded(itemAtEnd: NowPlayingPosterModel) {
        onboundarycallbackListener.onItemAtEndLoaded(itemAtEnd)
    }
}