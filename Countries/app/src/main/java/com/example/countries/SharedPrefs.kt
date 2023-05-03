package com.example.countries

import android.content.Context
import android.content.SharedPreferences
import android.view.MenuItem

object SharedPrefs {
    private const val APP_PREFERENCES = "app_preferences"
    lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
    }

    fun getAll(): MutableList<String> {
        val countryList = preferences.all.map { it.key }
        return countryList.toMutableList()
    }

    fun addSavedCountry(countryCode: String) {
        val editor = preferences.edit()
        editor.putBoolean(countryCode, true)
        editor.apply()
    }

    fun removeSavedCountry(countryCode: String) {
        val editor = preferences.edit()
        editor.remove(countryCode).commit()
    }

    fun checkSavedCountry(countryCode: String): Boolean {
       return preferences.getBoolean(countryCode, false)
    }
}

