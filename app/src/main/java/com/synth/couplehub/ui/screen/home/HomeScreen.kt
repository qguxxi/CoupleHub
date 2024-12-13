package com.synth.couplehub.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.synth.couplehub.ui.component.BottomAppBar

@Composable
fun HomeScreen(navController : NavController,modifier : Modifier = Modifier) {
    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            BottomAppBar(navController = navController)
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}

