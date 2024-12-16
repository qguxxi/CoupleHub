package com.synth.couplehub.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.synth.couplehub.data.local.SharedPreferencesHelper
import com.synth.couplehub.ui.screen.heart.HeartScreen
import com.synth.couplehub.ui.screen.honey.HoneyScreen
import com.synth.couplehub.ui.screen.intro.IntroScreen
import com.synth.couplehub.ui.screen.main.MainScreen
import com.synth.couplehub.ui.screen.pickdate.PickDateScreen
import com.synth.couplehub.ui.screen.profile.ProfileScreen
import com.synth.couplehub.ui.screen.signin.SignInScreen
import com.synth.couplehub.ui.screen.home.HomeScreen

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object SignIn : Screen("sign_In")
    data object Intro : Screen("intro")
    data object Horny : Screen("horny")
    data object Profile : Screen("profile")
    data object Heart : Screen("heart")
    data object Date : Screen("date")
    data object Main : Screen("main")
}
@Composable
fun CoupleHubNavHost() {

    val context = LocalContext.current
    val sharedPreferencesHelper = SharedPreferencesHelper(context)

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = if (sharedPreferencesHelper.hasValidToken()) Screen.Main.route else Screen.SignIn.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.SignIn.route) {
            SignInScreen(sharedPreferencesHelper = sharedPreferencesHelper,navController)
        }
        composable(Screen.Intro.route) {
            IntroScreen(navController = navController)
        }
        composable(Screen.Horny.route) {
            HoneyScreen(navController = navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
        composable(Screen.Heart.route) {
            HeartScreen(navController)
        }
        composable(Screen.Date.route) {
            PickDateScreen(navController = navController)
        }
        composable(Screen.Main.route) {
            MainScreen(navController = navController)
        }
    }
}

