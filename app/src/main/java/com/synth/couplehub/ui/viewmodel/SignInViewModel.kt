package com.synth.couplehub.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.synth.couplehub.data.local.UserSharePreference

class SignInViewModel(
    private val userPreferences: UserSharePreference
) : ViewModel() {

    fun saveLoginToken(token: String) {
        userPreferences.saveTokenUser(token)
    }

    fun isLoggedIn(): Boolean {
        return userPreferences.isLoggedIn()
    }

    fun logout() {
        userPreferences.clearLoginInfo()
    }

}