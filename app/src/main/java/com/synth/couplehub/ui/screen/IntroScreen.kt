package com.synth.couplehub.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.synth.couplehub.ui.navigation.Screen
import com.synth.couplehub.ui.theme.AppTypography
import com.synth.couplehub.ui.viewmodel.UserViewModel


@Composable
fun IntroScreen(navController : NavController,userViewModel: UserViewModel = viewModel(), modifier : Modifier = Modifier) {
    var inputUser by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFF896C7) ,
                        Color(0xFFFFDDEE) ,
                        Color(0xFFFFE9F3) ,
                        Color(0xFFFFFFFF)
                    ) ,
                    start = Offset(0f , 0f) ,
                    end = Offset(Float.POSITIVE_INFINITY , Float.POSITIVE_INFINITY)
                )
            )
    ){
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Tên của bạn là gì", style = AppTypography.bodyLarge.copy(fontSize = 36.sp, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(16.dp))
        Box {
            if (inputUser.isEmpty()) {
                Text(
                    text = "Nhập tên của bạn",
                    fontSize = 24.sp,
                    color = Color.Gray // Chữ mờ
                )
            }
            BasicTextField(
                value = inputUser ,
                keyboardActions = KeyboardActions(
                    onDone = {
                        userViewModel.updateUserName(inputUser)
                        navController.navigate(Screen.Home.route)
                    }
                ) ,
                textStyle = TextStyle(
                    fontSize = 24.sp // Đặt kích thước font tại đây
                ) ,
                maxLines = 1 ,
                singleLine = true ,
                onValueChange = { newInput ->
                    inputUser = newInput
                }
            )
        }
        Spacer(modifier = Modifier.weight(4f))
    }
}





@Preview
@Composable
private fun IntroScreenPreview() {
    IntroScreen(userViewModel = UserViewModel(), navController = rememberNavController())
}