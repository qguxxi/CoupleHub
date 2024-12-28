package com.synth.couplehub.ui.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.synth.couplehub.R
import com.synth.couplehub.ui.screen.heart.HeartScreen
import com.synth.couplehub.ui.screen.home.HomeScreen
import com.synth.couplehub.ui.screen.home.HomeViewModel
import com.synth.couplehub.ui.screen.profile.ProfileScreen

data class BottomNavigationItem(
    val route: String ,
    val selectedIcon: ImageVector ,
    val unselectedIcon: ImageVector ,
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
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                NavigationBar(
                    tonalElevation = 7.dp ,
                    modifier = Modifier
                        .navigationBarsPadding()
                        .padding(bottom = 8.dp)
                        .clip(shape = RoundedCornerShape(30.dp))
                        .background(color = MaterialTheme.colorScheme.surfaceContainer , shape = RoundedCornerShape(30.dp))
                        .height(64.dp)
                        .width(300.dp)
                ) {
                    items.forEachIndexed { index , item ->
                        val isSelected = selectedIndex == index
                        NavigationBarItem(
                            label = null ,
                            enabled = selectedIndex != index,
                            selected = isSelected ,
                            onClick = {
                                selectedIndex = index
                            } ,
                            alwaysShowLabel = false ,
                            icon = {
                                Icon(
                                    imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon ,
                                    contentDescription = item.route ,
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            } ,
                        )
                    }
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