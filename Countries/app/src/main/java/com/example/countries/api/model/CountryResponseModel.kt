package com.example.countries.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CountryResponseModel (
    @SerializedName("data") @Expose val data: List<Country>,
    @SerializedName("links") @Expose val links: List<Link>,
    @SerializedName("metadata") @Expose val metadata: Metadata
)
