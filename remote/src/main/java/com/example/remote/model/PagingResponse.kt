package com.example.remote.model

import com.google.gson.annotations.SerializedName

data class PagingResponse(
    @field:SerializedName("dates")
    val blackSources: DatesModel?,
    @field:SerializedName("page")
    val page: Int
)