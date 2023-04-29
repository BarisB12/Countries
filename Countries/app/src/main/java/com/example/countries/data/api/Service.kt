package com.example.countries.data.api

class Service {
    companion object {
        private const val BASE_URL = "https://wft-geo-db.p.rapidapi.com/"

        fun getCountryService(): CountryService {
            return CountryClient.getClient(BASE_URL).create(CountryService::class.java)
        }
    }
}