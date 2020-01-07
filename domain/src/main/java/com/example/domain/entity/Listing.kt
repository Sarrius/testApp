package com.example.domain.entity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList

data class Listing<T>(

    val pagedListLiveData: LiveData<PagedList<T>>,
    val nextPageState: MutableLiveData<NetworkState>
)