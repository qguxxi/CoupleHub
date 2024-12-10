package com.synth.couplehub.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.synth.couplehub.ui.screen.IntroScreen
import com.synth.couplehub.ui.screen.home.HomeScreen
import com.synth.couplehub.ui.screen.SignInScreen
import com.synth.couplehub.ui.viewmodel.SharedViewModel

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object SignIn : Screen("sign_In")
    data object Intro1 : Screen("intro")
}
@Composable
fun CoupleHubNavHost(sharedViewModel : SharedViewModel = viewModel()) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SignIn.route) {
        composable(Screen.Home.route) {
            HomeScreen(sharedViewModel = sharedViewModel)
        }
        composable(Screen.SignIn.route) {
            SignInScreen(navController)
        }
        composable(Screen.Intro1.route) {
            IntroScreen(sharedViewModel,navController)
        }
    }
}

