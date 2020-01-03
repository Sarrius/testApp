package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.dao.NowPlayingDao
import com.example.data.model.MovieDbModel

@Database(
    entities =
    [MovieDbModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DbTypeConverters::class)
abstract class Database : RoomDatabase() {

    abstract fun nowPlayingDao(): NowPlayingDao
}