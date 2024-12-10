package com.synth.couplehub.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import com.synth.couplehub.R
import com.synth.couplehub.ui.component.BottomBarSignIn
import com.synth.couplehub.ui.component.GoogleSignInButton
import com.synth.couplehub.ui.theme.AppTypography

@Composable
fun SignInScreen() {
    Scaffold(
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
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
            GoogleSignInButton(onClick = { /*TODO*/ } , isLoading = false)
            Spacer(modifier = Modifier.weight(3f))
            BottomBarSignIn(privacyOnClick = { /*TODO*/ }  , termServiceOnClick = { /*TODO*/ })
        }
    }
}

@Suppress("VisualLintAccessibilityTestFramework")
@Preview(showBackground = true)
@Composable
private fun SignInScreenPreview() {
    SignInScreen()
}