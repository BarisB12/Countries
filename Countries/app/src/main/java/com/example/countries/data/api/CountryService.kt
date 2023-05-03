package com.example.countries.data.api

import com.example.countries.data.api.model.CountryResponseModel
import com.example.countries.data.api.model.DetailResponseModel

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface CountryService {

    @GET("v1/geo/countries")
    suspend fun getAllCountries(
        @Header("X-RapidAPI-Host") host: String,
        @Header("X-RapidAPI-Key") key: String,
        @Query("limit") limit: Int,
        @Query("currencyCode") currencyCode: String = "EUR"
    ): CountryResponseModel

    @GET("v1/geo/countries/{code}")
    suspend fun countryDetails(
        @Header("X-RapidAPI-Host") host: String,
        @Header("X-RapidAPI-Key") key: String,
        @Path("code") code: String
    ): DetailResponseModel
}