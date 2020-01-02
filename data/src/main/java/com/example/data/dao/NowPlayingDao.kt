package com.example.data.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.data.model.NowPlayingMovieDto

@Dao
abstract class NowPlayingDao {

    @Insert(onConflict = REPLACE)
    abstract fun insertNowPlaying(nowPlaying: List<NowPlayingMovieDto>)

    @Query("SELECT * FROM NowPlayingMovieDto ORDER BY indexInResponse ASC")
    abstract fun getArticlesByFeedId(feedId: String): DataSource.Factory<Int, NowPlayingMovieDto>
}