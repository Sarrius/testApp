package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.dao.NowPlayingDao
import com.example.data.model.NowPlayingMovieDto

@Database(
    entities =
    [NowPlayingMovieDto::class],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {

    abstract fun nowPlayingDao(): NowPlayingDao
}