package com.example.remote.model

import com.google.gson.annotations.SerializedName

data class NowPlayingResponse(
    @field:SerializedName("dates")
    val datesModel: DatesModel,
    @field:SerializedName("page")
    val page: Int,
    @field:SerializedName("results")
    val nowPlayingMovies: List<MovieModel>
)