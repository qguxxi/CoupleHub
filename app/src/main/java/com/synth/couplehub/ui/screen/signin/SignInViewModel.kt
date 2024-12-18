package com.synth.couplehub.ui.screen.signin

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.synth.couplehub.data.local.SharedPreferencesHelper
import com.synth.couplehub.ui.navigation.Screen


class SignInViewModel(private val sharedPreferencesHelper: SharedPreferencesHelper) : ViewModel() {

    fun onTokenReceived(tokenId: String, navController: NavController) {
        sharedPreferencesHelper.saveUserToken(tokenId)
        navController.navigate(Screen.Main.route) {
            popUpTo(Screen.SignIn.route) {
                inclusive = true
            }
        }
    }
}