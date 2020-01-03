package com.example.remote.service

import com.example.remote.model.NowPlayingResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {
    @GET("movie/now_playing")
    fun getNowPlayingMovies(
        @Query("page") page: Int?
    ): Single<NowPlayingResponse>
}