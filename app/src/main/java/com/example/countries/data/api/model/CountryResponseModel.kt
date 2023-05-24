package com.example.countries.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CountryResponseModel (
    @SerializedName("data") val data: List<Country>,
    @SerializedName("links") val links: List<Link>,
    @SerializedName("metadata") val metadata: Metadata
)
