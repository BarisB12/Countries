package com.example.countries.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.data.api.repository.DetailRepository
import com.example.countries.data.api.model.DetailResponseModel
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {
    private var detailsRepository = DetailRepository()
    private var _detail = MutableLiveData<DetailResponseModel>()

    val detail: LiveData<DetailResponseModel> = _detail

    init {
    }

    fun getDetail(countryCode: String) {
        viewModelScope.launch {
            _detail.value = detailsRepository.getDetail(code = countryCode)
        }
    }
}