package com.synth.couplehub.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.synth.couplehub.R
import com.synth.couplehub.ui.component.ContinueButton
import com.synth.couplehub.ui.navigation.Screen
import com.synth.couplehub.ui.theme.AppTypography
import com.synth.couplehub.ui.theme.pinkGradient
import com.synth.couplehub.ui.viewmodel.SharedViewModel


@Composable
fun IntroScreen(sharedViewModel : SharedViewModel,navController : NavController, modifier : Modifier = Modifier) {
    var nameInput by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = pinkGradient,
                    start = Offset(0f , 0f) ,
                    end = Offset(Float.POSITIVE_INFINITY , Float.POSITIVE_INFINITY)
                )
            )
    ){
        Spacer(modifier = Modifier.weight(1f))
        Text(text = stringResource(id = R.string.input_name), style = AppTypography.bodyLarge.copy(fontSize = 32.sp, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            if (nameInput.isEmpty()) {
                Text(
                    text = stringResource(id = R.string.input),
                    fontSize = 24.sp,
                    color = Color.Gray, // Chữ mờ
                )
            }
            BasicTextField(
                value = nameInput ,
                keyboardActions = KeyboardActions(
                    onDone = {
                        sharedViewModel.setName(nameInput)
                        keyboardController?.hide()
                    }
                ),
                textStyle = TextStyle(fontSize = 24.sp, textAlign = TextAlign.Center),
                maxLines = 1 ,
                singleLine = true ,
                onValueChange = { newInput ->
                    nameInput = newInput
                },
                modifier = Modifier.fillMaxWidth(0.5f)

            )
        }
        Spacer(modifier = Modifier.weight(6f))
        ContinueButton(
            enable = nameInput.isNotEmpty() ,
            onClick =  {
                navController.navigate(Screen.Horny.route)
            }
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun HoneyScreen(sharedViewModel : SharedViewModel,navController : NavController, modifier : Modifier = Modifier) {
    var hornyInput by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = pinkGradient,
                    start = Offset(0f , 0f) ,
                    end = Offset(Float.POSITIVE_INFINITY , Float.POSITIVE_INFINITY)
                )
            )
    ){
        Spacer(modifier = Modifier.weight(1f))
        Text(text = stringResource(id = R.string.input_her_name), style = AppTypography.bodyLarge.copy(fontSize = 28.sp, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            if (hornyInput.isEmpty()) {
                Text(
                    text = stringResource(id = R.string.her_input),
                    fontSize = 24.sp,
                    color = Color.Gray // Chữ mờ
                )
            }
            BasicTextField(
                value = hornyInput ,
                keyboardActions = KeyboardActions(
                    onDone = {
                        sharedViewModel.setHornyName(name = hornyInput)
                        keyboardController?.hide()
                    }
                ),
                textStyle = TextStyle(fontSize = 24.sp, textAlign = TextAlign.Center),
                maxLines = 1 ,
                singleLine = true ,
                onValueChange = { newInput ->
                    hornyInput = newInput
                },
                modifier = Modifier.fillMaxWidth(0.5f)
            )
        }
        Spacer(modifier = Modifier.weight(6f))
        ContinueButton(
            enable = hornyInput.isNotEmpty() ,
            onClick =  {
                navController.navigate(Screen.Date.route)
            }
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}


@Preview
@Composable
private fun IntroScreenPreview() {
    IntroScreen(sharedViewModel = SharedViewModel() , navController = rememberNavController())
}
@Preview
@Composable
private fun HornyScreenPreview() {
    HoneyScreen(sharedViewModel = SharedViewModel() , navController = rememberNavController())
}
