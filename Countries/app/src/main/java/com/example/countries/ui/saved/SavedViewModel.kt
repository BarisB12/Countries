package com.example.countries.ui.saved

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countries.SharedPrefs
import kotlinx.coroutines.launch

class SavedViewModel : ViewModel() {
    private var _savedList = MutableLiveData<MutableList<String>>()

    val savedList: LiveData<MutableList<String>> = _savedList

    init {
        viewModelScope.launch {
            _savedList.value = SharedPrefs.getAll()
        }
    }
}


