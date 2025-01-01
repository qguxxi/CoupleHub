package com.synth.couplehub.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.synth.couplehub.HomeViewModelFactory
import com.synth.couplehub.ui.screen.heart.HeartScreen
import com.synth.couplehub.ui.screen.home.HomeScreen
import com.synth.couplehub.ui.screen.main.MainScreen
import com.synth.couplehub.ui.screen.profile.ProfileScreen
import com.synth.couplehub.ui.screen.signin.SignInScreen
import com.synth.couplehub.ui.screen.signin.SignInViewModel
import com.synth.couplehub.usecase.SharedPreferencesHelper

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object SignIn : Screen("sign_In")
    data object Profile : Screen("profile")
    data object Heart : Screen("heart")
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
            HomeScreen(viewModel = viewModel(factory = HomeViewModelFactory(LocalContext.current))
            )
        }
        composable(Screen.SignIn.route) {
            SignInScreen(viewmodel = SignInViewModel(SharedPreferencesHelper(context)),navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
        composable(Screen.Heart.route) {
            HeartScreen(navController)
        }
        composable(Screen.Main.route) {
            MainScreen(navController = navController)
        }
    }
}

