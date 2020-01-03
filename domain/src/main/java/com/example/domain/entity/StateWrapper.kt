package com.example.domain.entity

data class StateWrapper(
    val networkState: NetworkState? = null,
    val supportData: Any? = null
){
    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): NetworkState? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            networkState
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): NetworkState?  = networkState
}