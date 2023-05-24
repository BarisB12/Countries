package com.example.countries.data.api.repository

import com.example.countries.BuildConfig
import com.example.countries.data.api.CountryService
import com.example.countries.data.api.Service
import com.example.countries.data.api.model.DetailResponseModel

class DetailRepository(
    private var service: CountryService = Service.getCountryService()

) {
    suspend fun getDetail(code: String): DetailResponseModel {
        return this.service.countryDetails(
            host = BuildConfig.API_X_RAPIDAPI_HOST,
            key = BuildConfig.API_KEY,
            code = code
        )
    }
}