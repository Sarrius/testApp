package com.example.data.repository.datasource.local

import androidx.paging.DataSource
import com.example.data.model.MovieDbModel
import io.reactivex.Single

class NowPlayingDbDataSource: BaseDbDataSource() {

    fun getNowPlaying(): DataSource.Factory<Int, MovieDbModel> {
        return database.nowPlayingDao().getNowPlaying()
    }

    fun getNowPlayingById(id: Int): Single<MovieDbModel> {
        return database.nowPlayingDao().getNowPlayingById(id)
    }
}