package com.synth.couplehub.usecase

import android.content.Context
import androidx.compose.ui.platform.LocalContext

class SharedPreferencesHelper(context: Context) {
    companion object {
        const val KEY_USER_TOKEN = "user_token"
    }

    private val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)


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
