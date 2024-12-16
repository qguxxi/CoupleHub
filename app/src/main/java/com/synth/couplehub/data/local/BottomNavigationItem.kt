package com.synth.couplehub.data.local

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val route: String ,
    val selectedIcon: ImageVector ,
    val unselectedIcon: ImageVector ,
)
