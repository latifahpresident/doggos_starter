package com.latifah.doggo.data.models

import com.squareup.moshi.Json

data class DogImage(
    @Json(name = "message")
    val message: String,
    @Json(name = "status")
    val status: String
)
