package com.tsl.momi.utils

import android.content.Context
import android.preference.PreferenceManager

class PreferencesHelper(context: Context){
    companion object {
        const val TOKEN = "token"
    }

    private val preferences = PreferenceManager .getDefaultSharedPreferences(context)

    // save token
    var token = preferences.getString(TOKEN, null)
    set(value) = preferences.edit().putString(TOKEN, value).apply()
}