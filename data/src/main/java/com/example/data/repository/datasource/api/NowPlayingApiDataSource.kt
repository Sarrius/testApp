package com.example.data.repository.datasource.api

import android.content.Context
import android.util.Log
import com.example.data.mappings.mapToDb
import com.example.data.model.MovieDbModel
import com.example.remote.managers.BaseApiManager
import com.example.remote.managers.MovieApiManager
import io.reactivex.Single
import timber.log.Timber

class NowPlayingApiDataSource(
    movieApiManager: MovieApiManager,
    applicationContext: Context
) : BaseApiManager<MovieApiManager>(movieApiManager, applicationContext) {

    fun getNowPlaying(page: Int?): Single<List<MovieDbModel>> {
        return getExecutorSingle()
            .flatMap {
                Timber.log(Log.DEBUG, Thread.currentThread().name)
                it.getNowPlayingMovies(page) }
            .map { movies -> movies.map { it.mapToDb() } }
    }
}