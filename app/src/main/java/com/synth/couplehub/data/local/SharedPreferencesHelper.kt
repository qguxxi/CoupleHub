package com.synth.couplehub.data.local

import android.content.Context

class SharedPreferencesHelper(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    companion object {
        const val KEY_DATE_SELECTED = "date_selected"
    }

    fun saveSelectedDate(date: Long) {
        sharedPreferences.edit().putLong(KEY_DATE_SELECTED, date).apply()
    }

    fun hasUserSetDate(): Boolean {
        return sharedPreferences.contains(KEY_DATE_SELECTED)
    }

    fun getSelectedDate(): Long? {
        return if (sharedPreferences.contains(KEY_DATE_SELECTED)) sharedPreferences.getLong(KEY_DATE_SELECTED, -1) else null
    }
}
