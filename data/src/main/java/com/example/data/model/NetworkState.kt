package com.example.data.model

@Suppress("DataClassPrivateConstructor")
data class NetworkState private constructor(
    val status: Status,
    var throwable: Throwable? = null
) {
    companion object {
        val SUCCESS = NetworkState(Status.SUCCESS)
        val PROGRESS = NetworkState(Status.PROGRESS)
        fun error(throwable: Throwable?) = NetworkState(Status.FAILED, throwable)
    }
}