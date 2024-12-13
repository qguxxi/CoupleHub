package com.synth.couplehub.ui

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.synth.couplehub.ui.navigation.CoupleHubNavHost

@Composable
fun CoupleHubApp() {
    CoupleHubNavHost()
}