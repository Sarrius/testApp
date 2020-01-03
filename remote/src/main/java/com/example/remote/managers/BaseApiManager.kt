package com.example.remote.managers

import android.content.Context
import com.example.common.utils.NetworkUtil
import io.reactivex.Single

open class BaseApiManager<S>(private val apiExecutor: S, private val appContext: Context) {

    protected fun getExecutorSingle(): Single<S> = checkNetwork() // todo: catch exceptions

    //    Return exception if network in not available
    //    do not have much time to make great retrofit exceptions
    //    so I just throw base exception
    private fun checkNetwork() = Single.fromCallable {
        if (!NetworkUtil.isNetworkAvailable(appContext)) {
            throw Exception("No internet")
        }
        apiExecutor
    }
}