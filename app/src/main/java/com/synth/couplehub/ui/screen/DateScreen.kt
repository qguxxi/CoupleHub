package com.synth.couplehub.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.synth.couplehub.ui.component.ContinueButton
import com.synth.couplehub.ui.component.DatePickerDocked
import com.synth.couplehub.ui.navigation.Screen
import com.synth.couplehub.ui.theme.AppTypography
import com.synth.couplehub.ui.theme.pinkGradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateScreen(navController : NavController ,dateViewModel : DateViewModel = viewModel()) {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val isDateSelected = datePickerState.selectedDateMillis != null
    val gradientBrush = remember {
        Brush.linearGradient(
            colors = pinkGradient,
            start = Offset(0f, 0f),
            end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = gradientBrush
            )
    ) {
        Spacer(modifier = Modifier.weight(2f))
        Text(
            text = "Ngày bạn yêu nhau",
            style = AppTypography.bodyLarge.copy(fontSize = 32.sp, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(32.dp))
        DatePickerDocked(
            showDatePicker = showDatePicker,
            onShowDatePickerChange = { showDatePicker = it },
            datePickerState = datePickerState
        )
        Spacer(modifier = Modifier.weight(8f))
        ContinueButton(enable = isDateSelected , onClick = { navController.navigate(Screen.Home.route) })
        Spacer(modifier = Modifier.weight(2f))
    }
}


@Preview
@Composable
private fun DateScreenPreview() {
    DateScreen(navController = rememberNavController())
}