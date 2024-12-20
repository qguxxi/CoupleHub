package com.synth.couplehub.ui.screen.pickdate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.synth.couplehub.ui.theme.AppTypography
import com.synth.couplehub.ui.theme.pinkGradient

@Composable
fun PickDateScreen(navController: NavController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = pinkGradient,
                    start = Offset(0f, 0f),
                    end = Offset.Infinite
                )
            )
    ) {
        Spacer(modifier = Modifier.weight(2f))
        Text(
            text = "Ngày bạn yêu nhau",
            style = AppTypography.bodyLarge.copy(fontSize = 32.sp, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Spacer(modifier = Modifier.weight(8f))


        Spacer(modifier = Modifier.weight(2f))
    }
}
