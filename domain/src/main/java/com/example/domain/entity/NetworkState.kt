package com.example.domain.entity

@Suppress("DataClassPrivateConstructor")
data class NetworkState private constructor(
    var status: Status,
    var throwable: Throwable? = null
) {
    companion object {
        val SUCCESS =
            NetworkState(Status.SUCCESS)
        val PROGRESS =
            NetworkState(Status.PROGRESS)
        fun error(throwable: Throwable?) = NetworkState(
            Status.FAILED,
            throwable
        )
    }
}