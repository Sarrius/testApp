package com.example.data.model

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

data class Listing<T>(

    val pagedListLiveData: LiveData<PagedList<T>>
)