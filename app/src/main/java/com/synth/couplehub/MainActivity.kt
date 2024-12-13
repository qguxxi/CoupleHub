package com.synth.couplehub

import android.app.Application
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.synth.couplehub.ui.theme.AppTheme
import com.synth.couplehub.ui.CoupleHubApp
import com.synth.couplehub.ui.screen.DateScreen
import com.synth.couplehub.ui.screen.IntroScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContent {
            AppTheme {
               CoupleHubApp()
            }
        }
    }
}