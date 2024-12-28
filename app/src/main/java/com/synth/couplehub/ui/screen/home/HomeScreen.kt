package com.synth.couplehub.ui.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.synth.couplehub.CoupleHubViewModelFactory
import com.synth.couplehub.ui.screen.main.BottomNavigationItem


@Composable
fun HomeScreen(
    homeViewModel : HomeViewModel = viewModel(
        factory = CoupleHubViewModelFactory(
            LocalContext.current
        )
    ) ,
    navController : NavController ,
) {

}


