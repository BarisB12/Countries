package com.example.countries.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountryClient { companion object {
    fun getClient(baseUrl:String) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
}