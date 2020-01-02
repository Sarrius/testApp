package com.example.data.model

import androidx.room.Entity

@Entity
data class NowPlayingMovieDto (
    val id: String): BaseDto()