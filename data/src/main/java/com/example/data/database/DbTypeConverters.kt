package com.example.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DbTypeConverters {
    @TypeConverter
    fun fromIntString(value: String?): List<Int>? {
        value?.let { }
        return Gson().fromJson(value, object : TypeToken<List<Int>>() {}.type)
    }

    @TypeConverter
    fun toIntListJson(list: List<Int>? = null): String? {
        return list?.let { Gson().toJson(it) }
    }
}