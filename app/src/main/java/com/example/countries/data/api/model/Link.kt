package com.example.countries.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("href") val href: String,
    @SerializedName("rel") val rel: String
)
