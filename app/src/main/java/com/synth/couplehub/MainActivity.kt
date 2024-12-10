package com.synth.couplehub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.compose.AppTheme
import com.synth.couplehub.ui.CoupleHubApp
import com.synth.couplehub.ui.screen.SignInScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            AppTheme {
                CoupleHubApp()
            }
        }
    }
}
