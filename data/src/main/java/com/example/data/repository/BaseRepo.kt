package com.example.data.repository

import android.content.Context
import com.example.data.database.Database
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseRepo: KoinComponent{


    protected val database: Database by inject()

    abstract fun requestInitialData(): Single<Unit>
    abstract fun refresh():Single<Unit>

}