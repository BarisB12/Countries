package com.example.countries.api

import com.example.countries.api.model.CountryResponseModel
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface CountryService {

    @GET("v1/geo/countries?limit={limit}&currencyCode=EUR")
    fun getAllCountries(
        @Header("X-RapidAPI-Host") host: String,
        @Header("X-RapidAPI-Key") key: String,
        @Path("limit") limit: Int
    ): Call<CountryResponseModel>

   /* @GET("v1/geo/countries/{code}")
    fun countryDetails(
        @Header("X-RapidAPI-Host") host:String,
        @Header("X-RapidAPI-Key") key:String,
        @Path("code") code:String
    ): Call<CountryDetailsResponse>*/
}