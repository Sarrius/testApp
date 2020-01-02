package com.example.remote.model

import com.google.gson.annotations.SerializedName

data class DatesModel(
    @field:SerializedName("minimum")
    val minimum: String,

    @field:SerializedName("maximum")
    val maximum: String
)