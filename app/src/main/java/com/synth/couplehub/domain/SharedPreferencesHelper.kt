package com.synth.couplehub.domain

import android.content.Context

class SharedPreferencesHelper(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    companion object {
        const val KEY_USER_TOKEN = "user_token"
    }

    fun saveUserToken(token: String) {
        sharedPreferences.edit().putString(KEY_USER_TOKEN , token).apply()
    }

    fun getUserToken(): String? {
        return sharedPreferences.getString(KEY_USER_TOKEN , null)
    }

    fun clearUserToken() {
        sharedPreferences.edit().remove(KEY_USER_TOKEN).apply()
    }

    fun hasValidToken(): Boolean {
        return sharedPreferences.contains(KEY_USER_TOKEN)
    }
}