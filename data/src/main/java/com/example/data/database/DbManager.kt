package com.example.data.database

import android.content.Context
import androidx.room.Room

object DbManager{

    fun getRoom(context: Context, dbName: String): Database {
        return Room.databaseBuilder(context, Database::class.java, dbName).build()
    }
}