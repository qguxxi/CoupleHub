package com.synth.couplehub.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.stevdzasan.onetap.OneTapSignInWithGoogle
import com.stevdzasan.onetap.rememberOneTapSignInState
import com.synth.couplehub.BuildConfig
import com.synth.couplehub.R
import com.synth.couplehub.ui.component.BottomBarSignIn
import com.synth.couplehub.ui.component.GoogleSignInButton
import com.synth.couplehub.ui.navigation.Screen
import com.synth.couplehub.ui.theme.AppTypography

@Composable
fun SignInScreen(navController : NavController) {
    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            val clientKeyApi = BuildConfig.CLIENT_KEY_API
            val state = rememberOneTapSignInState()
            OneTapSignInWithGoogle(
                state = state,
                clientId = clientKeyApi,
                onTokenIdReceived = { tokenId ->
                    navController.navigate(Screen.Intro.route)
                    Log.d("GOOGLE SIGN IN", tokenId)
                },
                onDialogDismissed = { message ->
                    Log.d("GOOGLE SIGN IN", message)
                }
            )

            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(id = R.string.app_name),
                style = AppTypography.displayLarge,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFA2EAC)
                )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(id = R.string.app_detail),
                style = AppTypography.titleSmall,
                modifier = Modifier.alpha(0.5f)
                )
            Spacer(modifier = Modifier.weight(2f))
            Image(painter = painterResource(id = R.drawable.logo_large) , contentDescription = null)
            Spacer(modifier = Modifier.height(240.dp))
            GoogleSignInButton(onClick = { state.open() } , isLoading = false)
            Spacer(modifier = Modifier.weight(3f))
            BottomBarSignIn(privacyOnClick = { /*TODO*/ }  , termServiceOnClick = { /*TODO*/ })
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignInScreenPreview() {
    SignInScreen(navController = rememberNavController())
}