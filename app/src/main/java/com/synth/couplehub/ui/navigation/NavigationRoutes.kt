package com.synth.couplehub.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.synth.couplehub.ui.screen.HomeScreen
import com.synth.couplehub.ui.screen.SignInScreen

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object SignIn : Screen("sign_In")
}
@Composable
fun CoupleHubNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.SignIn.route) {
        composable(Screen.Home.route) {
            HomeScreen()
        }
        composable(Screen.SignIn.route) {
            SignInScreen()
        }
    }
}

