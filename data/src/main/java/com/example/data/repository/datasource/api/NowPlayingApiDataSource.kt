package com.example.data.repository.datasource.api

import android.content.Context
import com.example.data.mappings.mapToDb
import com.example.data.model.MovieDbModel
import com.example.remote.managers.BaseApiManager
import com.example.remote.managers.MovieApiManager
import io.reactivex.Single

class NowPlayingApiDataSource(
    movieApiManager: MovieApiManager,
    applicationContext: Context
) : BaseApiManager<MovieApiManager>(movieApiManager, applicationContext) {

    fun getNowPlaying(page: Int?): Single<List<MovieDbModel>> {
        return getExecutorSingle()
            .flatMap { it.getNowPlayingMovies(page) }
            .map { movies -> movies.map { it.mapToDb() } }
    }
}