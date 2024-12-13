package com.synth.couplehub.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.synth.couplehub.ui.component.BottomAppBar

@Composable
fun ProfileScreen(navController : NavController , modifier : Modifier = Modifier) {
    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().padding(it)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            BottomAppBar(navController = navController)
        }
    }
}