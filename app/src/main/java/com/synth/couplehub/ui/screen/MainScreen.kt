package com.synth.couplehub.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.synth.couplehub.R
import com.synth.couplehub.ui.screen.home.HomeScreen

data class BottomNavigationItem(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

@Composable
fun MainScreen(navController : NavController,modifier : Modifier = Modifier) {
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        bottomBar = {
            val items = listOf(
                BottomNavigationItem(
                    "home",
                    ImageVector.vectorResource(R.drawable.home_pink),
                    ImageVector.vectorResource(R.drawable.home)
                ) ,
                BottomNavigationItem(
                    "heart",
                    ImageVector.vectorResource(R.drawable.heart_pink),
                    ImageVector.vectorResource(R.drawable.heart)
                ) ,
                BottomNavigationItem(
                    "profile",
                    ImageVector.vectorResource(R.drawable.profile_pink),
                    ImageVector.vectorResource(R.drawable.profile)
                )
            )
            NavigationBar(
                tonalElevation = 7.dp,
            ) {
                items.forEachIndexed { index,item ->
                    val isSelected = selectedIndex == index
                    NavigationBarItem(
                        label = null,
                        selected = isSelected,
                        onClick = {
                            selectedIndex = index
                        },
                        alwaysShowLabel = false,
                        icon = {
                            Icon(
                                imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                                contentDescription = item.route,
                                tint = Color.Unspecified,
                            )
                        },
                    )
                }
            }
        }
    ) {
        ContentScreen(navController = navController , index = selectedIndex,modifier.padding(it))
    }
}

@Composable
fun ContentScreen(navController : NavController,index: Int,modifier : Modifier = Modifier) {
    when(index) {
        0 -> HomeScreen(navController = navController)
        1 -> HeartScreen(navController = navController)
        2 -> ProfileScreen(navController = navController)
    }
}