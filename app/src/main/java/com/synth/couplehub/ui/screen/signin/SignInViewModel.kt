package com.synth.couplehub.ui.screen.signin

import androidx.lifecycle.ViewModel
import com.synth.couplehub.usecase.SharedPreferencesHelper


class SignInViewModel(private val sharedPreferencesHelper: SharedPreferencesHelper) : ViewModel() {

    fun onTokenReceived(tokenId: String) {
        sharedPreferencesHelper.saveUserToken(tokenId)
    }
}