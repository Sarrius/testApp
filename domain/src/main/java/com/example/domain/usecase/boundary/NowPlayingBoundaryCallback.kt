package com.example.domain.usecase.boundary

import androidx.paging.PagedList
import com.example.domain.entity.NowPlayingMovieModel

class NowPlayingBoundaryCallback(private val onboundarycallbackListener: BoundaryCallbackListener
) : PagedList.BoundaryCallback<NowPlayingMovieModel>(){

    override fun onZeroItemsLoaded() {
        onboundarycallbackListener.onZeroLoaded()
    }

    override fun onItemAtEndLoaded(itemAtEnd: NowPlayingMovieModel) {
        onboundarycallbackListener.onItemAtEndLoaded(itemAtEnd)
    }
}