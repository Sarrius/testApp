package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieDbModel(
    val adult: Boolean?,
    val backdropPath: String?,
    val genreIds: List<Int?>?,
    @PrimaryKey
    val id: Int,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?,
    val video: Boolean?,
    val voteAverage: Int?,
    val voteCount: Int?
) : BaseDto()