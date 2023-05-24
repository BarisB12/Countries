package com.example.countries.data.api.model


import com.google.gson.annotations.SerializedName

data class DetailResponseModel(
    @SerializedName("data")
    val `data`: Data
)