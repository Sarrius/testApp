package com.example.domain.entity

data class NowPlayingMovieExtendedModel(
    val id: Int,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?,
    val voteAverage: Double?,
    val voteCount: Int?
)