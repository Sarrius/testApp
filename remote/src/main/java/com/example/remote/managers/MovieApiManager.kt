package com.example.remote.managers

import android.content.Context
import com.example.remote.model.MovieModel
import com.example.remote.service.MoviesService
import io.reactivex.Single

class MovieApiManager(moviesService: MoviesService, applicationContext: Context
) : BaseApiManager<MoviesService>(moviesService, applicationContext){

    fun getNowPlayingMovies(page: Int): Single<List<MovieModel>> {
        return getExecutorSingle().flatMap {
            it.getNowPlayingMovies(page)
        }.map { it.nowPlayingMovies }
    }
}