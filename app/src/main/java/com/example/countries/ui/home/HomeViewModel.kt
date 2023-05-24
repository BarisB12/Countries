package com.example.countries.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.SharedPrefs
import com.example.countries.data.api.model.Country
import com.example.countries.data.api.repository.CountriesRepository
import kotlinx.coroutines.launch
class HomeViewModel: ViewModel() {

    private var countriesRepository = CountriesRepository()
    private var _countryList = MutableLiveData<List<Country>>()

    val countryList: LiveData<List<Country>> = _countryList

    init {
        viewModelScope.launch {
            val countries = countriesRepository.getAllCountries()
           countries.data.forEach {
               it.isFavorited = SharedPrefs.checkSavedCountry(it.name)
           }
            _countryList.value = countries.data
        }
    }
}
