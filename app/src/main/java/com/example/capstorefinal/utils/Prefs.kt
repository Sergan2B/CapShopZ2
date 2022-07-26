package com.example.capstorefinal.utils

import android.content.Context

class Prefs(context: Context) {
    private val preferences = context.getSharedPreferences("settings.txt", Context.MODE_PRIVATE)

    fun saveState(){
        preferences.edit().putBoolean("isShown", true).apply()
    }

    fun isShown(): Boolean {
        return preferences.getBoolean("isShown", false)
    }
}