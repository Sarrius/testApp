package com.example.data.repository

import android.content.Context
import com.example.data.database.Database
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseRepo: KoinComponent{

    val database: Database by inject()
    val context: Context by inject()


}