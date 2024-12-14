package com.synth.couplehub.ui.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.synth.couplehub.R

// Triển khai bottom navigation bar

data class BottomNavigationItem(
    val title : String ,
    val selectedIcon : ImageVector ,
    val unselectedIcon : ImageVector ,
)
@Composable
fun NavigationAppBar(navController: NavController) {
    val items = listOf(
        BottomNavigationItem(
            "home",
            ImageVector.vectorResource(R.drawable.home_pink),
            ImageVector.vectorResource(R.drawable.home)
        ),
        BottomNavigationItem(
            "heart",
            ImageVector.vectorResource(R.drawable.heart_pink),
            ImageVector.vectorResource(R.drawable.heart)
        ),
        BottomNavigationItem(
            "profile",
            ImageVector.vectorResource(R.drawable.profile_pink),
            ImageVector.vectorResource(R.drawable.profile)
        )
    )

    var selectedIconIndex by rememberSaveable { mutableIntStateOf(0) }
    NavigationBar(
        tonalElevation = 7.dp,
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                label = null,
                selected = selectedIconIndex == index,
                onClick = {
                    selectedIconIndex = index
                },
                alwaysShowLabel = false,
                icon = {
                    Icon(
                        imageVector = if (selectedIconIndex == index) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.title,
                        tint = Color.Unspecified,
                    )
                },
            )
        }
    }
}


@Preview
@Composable
fun Preview() {
    NavigationAppBar(navController = rememberNavController())
}