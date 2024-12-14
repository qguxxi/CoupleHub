package com.synth.couplehub.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.synth.couplehub.R
import com.synth.couplehub.ui.screen.DateScreen
import com.synth.couplehub.ui.screen.HoneyScreen
import com.synth.couplehub.ui.screen.IntroScreen
import com.synth.couplehub.ui.screen.ProfileScreen
import com.synth.couplehub.ui.screen.SignInScreen
import com.synth.couplehub.ui.screen.home.HomeScreen

sealed class Screen(val route: String, val idIcon: Int?) {
    data object Home : Screen("home",R.drawable.home)
    data object SignIn : Screen("sign_In",null)
    data object Intro : Screen("intro",null)
    data object Horny : Screen("horny",null)
    data object Profile : Screen("profile",R.drawable.profile)
    data object Heart : Screen("heart",R.drawable.heart)
    data object Date : Screen("date",null)
}
@Composable
fun CoupleHubNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SignIn.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.SignIn.route) {
            SignInScreen(navController)
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
            ProfileScreen(navController)
        }
        composable(Screen.Date.route) {
            DateScreen(navController = navController)
        }
    }
}

