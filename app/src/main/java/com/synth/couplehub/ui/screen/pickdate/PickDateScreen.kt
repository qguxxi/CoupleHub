package com.synth.couplehub.ui.screen.pickdate

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.synth.couplehub.data.local.SharedPreferencesHelper
import com.synth.couplehub.ui.component.ContinueButton
import com.synth.couplehub.ui.component.DatePickerDocked
import com.synth.couplehub.ui.navigation.Screen
import com.synth.couplehub.ui.theme.AppTypography
import com.synth.couplehub.ui.theme.pinkGradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PickDateScreen(navController: NavController) {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val isDateSelected = datePickerState.selectedDateMillis != null

    val context = LocalContext.current
    val sharedPreferencesHelper = remember { SharedPreferencesHelper(context) }

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
        DatePickerDocked(
            showDatePicker = showDatePicker,
            onShowDatePickerChange = { showDatePicker = it },
            datePickerState = datePickerState
        )
        Spacer(modifier = Modifier.weight(8f))

        ContinueButton(
            enable = isDateSelected,
            onClick = {
                // Lưu thông tin ngày khi người dùng bấm Continue
                sharedPreferencesHelper.saveSelectedDate(datePickerState.selectedDateMillis ?: 0)

                // Điều hướng đến màn hình Home
                navController.navigate(Screen.Main.route) {
                    popUpTo(0) { inclusive = true }
                }
            }
        )
        Spacer(modifier = Modifier.weight(2f))
    }
}
