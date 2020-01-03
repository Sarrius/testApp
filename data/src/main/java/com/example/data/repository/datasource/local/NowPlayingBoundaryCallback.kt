package com.example.data.repository.datasource.local

import androidx.paging.PagedList
import com.example.data.model.MovieDbModel

class NowPlayingBoundaryCallback(): PagedList.BoundaryCallback<MovieDbModel>(){

    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()
    }

    override fun onItemAtEndLoaded(itemAtEnd: MovieDbModel) {
        super.onItemAtEndLoaded(itemAtEnd)
    }
}