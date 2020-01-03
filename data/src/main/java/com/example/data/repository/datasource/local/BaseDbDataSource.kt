package com.example.data.repository.datasource.local

import android.content.Context
import com.example.data.database.Database
import org.koin.core.KoinComponent
import org.koin.core.inject

open class BaseDbDataSource: KoinComponent {

    internal val database: Database by inject()
    private val context: Context by inject()

}