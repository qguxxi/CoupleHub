package com.synth.couplehub.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.synth.couplehub.R
import com.synth.couplehub.ui.navigation.Screen

@Composable
fun BottomAppBar(navController: NavController, modifier: Modifier = Modifier) {
    val currentDestination = remember { navController.currentDestination }
    val isHomeScreen = currentDestination?.route == Screen.Home.route
    val isProfileScreen = currentDestination?.route == Screen.Profile.route
    val isHeartScreen = currentDestination?.route == Screen.Heart.route

    Row(
        modifier = modifier
            .background(color = Color(0xFFFAF3F4))
            .height(75.dp)
            .fillMaxWidth()
            .padding(16.dp),
        
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        BottomAppBarIcon(
            isSelected = isHomeScreen,
            iconRes = R.drawable.home,
            selectedIconRes = R.drawable.home_pink,
            contentDescription = "Trang chủ",
            onClick = {
                if (!isHomeScreen) {
                    navController.navigate(Screen.Home.route) {
                        launchSingleTop = true
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                }
            }
        )

        BottomAppBarIcon(
            isSelected = isHeartScreen,
            iconRes = R.drawable.heart,
            selectedIconRes = R.drawable.heart_pink,
            contentDescription = "Cài đặt",
            onClick = {
                if (!isHeartScreen) {
                    navController.navigate(Screen.Heart.route) {
                        launchSingleTop = true
                        popUpTo(Screen.Heart.route) { inclusive = true }
                    }
                }
            }
        )

        BottomAppBarIcon(
            isSelected = isProfileScreen,
            iconRes = R.drawable.profile,
            selectedIconRes = R.drawable.profile_pink,
            contentDescription = "Trang chủ",
            onClick = {
                if (!isProfileScreen) {
                    navController.navigate(Screen.Profile.route) {
                        launchSingleTop = true
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                }
            }
        )
    }
}

@Composable
fun BottomAppBarIcon(
    isSelected: Boolean,
    iconRes: Int,
    selectedIconRes: Int,
    contentDescription: String,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        enabled = !isSelected
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = if (isSelected) selectedIconRes else iconRes),
            contentDescription = contentDescription,
            tint = Color.Unspecified
        )
    }
}

@Preview
@Composable
fun Preview() {
    BottomAppBar(navController = rememberNavController())
}