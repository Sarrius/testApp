package com.example.data.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.common.utils.Constants
import com.example.data.model.MovieDbModel
import io.reactivex.Single
import timber.log.Timber

@Dao
abstract class NowPlayingDao {

    @Insert(onConflict = REPLACE)
    abstract fun insertNowPlaying(nowPlaying: List<MovieDbModel>)

    @Query("SELECT * FROM MovieDbModel ORDER BY indexInResponse ASC")
    abstract fun getNowPlaying(): DataSource.Factory<Int, MovieDbModel>

    @Query("SELECT COUNT(*) FROM MovieDbModel")
    abstract fun getNextIndexInNowPlaying(): Int

    @Query("SELECT MAX(nextPage) FROM MovieDbModel ORDER BY indexInResponse ASC")
    abstract fun getNexPage(): Int

    @Query("DELETE FROM MovieDbModel")
    abstract fun removeAllNowPlaying()

    @Query("SELECT * FROM MovieDbModel WHERE id=:id")
    abstract fun getNowPlayingById(id: Int): Single<MovieDbModel>

    fun insertAllNowPlaying(nowPlaying: List<MovieDbModel>, rewrite: Boolean) {
        if (nowPlaying.isEmpty()) return
        try {
            if(rewrite){removeAllNowPlaying()}
            insertNowPlaying(indexedItems(nowPlaying))
        } catch (exception: Exception) {
            Timber.e(exception)
            throw Exception(exception)
        }
    }

    private fun indexedItems(nowPlaying: List<MovieDbModel>): List<MovieDbModel> {
        val start = getNextIndexInNowPlaying()
        var nextPage = (start + Constants.pageSize - 1) / Constants.pageSize

        Timber.d("nextPage = $nextPage")

        return nowPlaying.mapIndexed { index, child ->
            val indxInResp = start + index
            child.indexInResponse = indxInResp
            Timber.d("indexInResponse = $indxInResp")

            child.nextPage = nextPage + 1
            child
        }
    }

}