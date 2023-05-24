package com.example.countries.data.api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("code") val code: String,
    @SerializedName("currencyCodes") val currencyCodes: List<String>,
    @SerializedName("name") val name: String,
    @SerializedName("wikiDataId") val wikiDataId: String,
    var isFavorited: Boolean
)
