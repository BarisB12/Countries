package com.example.countries.data.api.repository

import com.example.countries.BuildConfig
import com.example.countries.data.api.CountryService
import com.example.countries.data.api.Service
import com.example.countries.data.api.model.CountryResponseModel

class CountriesRepository(
    private var service: CountryService = Service.getCountryService()
) {
    suspend fun getAllCountries(): CountryResponseModel {
        return this.service.getAllCountries(
            host = BuildConfig.API_X_RAPIDAPI_HOST,
            key = BuildConfig.API_KEY,
            limit = 10
        )
    }
}