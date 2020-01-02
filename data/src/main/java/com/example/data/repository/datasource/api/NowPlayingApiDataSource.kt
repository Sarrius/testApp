package com.example.data.repository.datasource.api

import com.example.remote.managers.MovieApiManager

class NowPlayingApiDataSource(private val movieApiManager: MovieApiManager){

    fun getNowPlaying(page: Int){
        movieApiManager.getNowPlayingMovies(page)
            .map {  }
    }
}