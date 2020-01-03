package com.example.data.repository

import android.content.Context
import com.example.data.database.Database
import io.reactivex.disposables.CompositeDisposable
import org.koin.core.KoinComponent
import org.koin.core.inject

abstract class BaseRepo: KoinComponent{

    protected val compositeDisposable = CompositeDisposable()
    protected val database: Database by inject()

    abstract fun requestInitialData()
    abstract fun refresh()

    fun clear(){
        compositeDisposable.clear()
    }

    fun dispose(){
        compositeDisposable.dispose()
    }
}