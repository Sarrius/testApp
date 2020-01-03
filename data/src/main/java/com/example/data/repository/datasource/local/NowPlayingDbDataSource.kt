package com.example.data.repository.datasource.local

import androidx.paging.DataSource
import com.example.data.model.MovieDbModel

class NowPlayingDbDataSource(): BaseDbDataSource() {

    fun getNowPlaying(): DataSource.Factory<Int, MovieDbModel> {
        return database.nowPlayingDao().getNowPlayingByPage()
    }
}