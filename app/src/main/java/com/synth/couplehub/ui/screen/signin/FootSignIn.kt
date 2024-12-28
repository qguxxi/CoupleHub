package com.synth.couplehub.ui.screen.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.synth.couplehub.R
import com.synth.couplehub.ui.theme.AppTypography

@Composable
fun FootSignIn(privacyOnClick : () -> Unit , termServiceOnClick: () -> Unit , modifier : Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.width(16.dp))
        }
        HorizontalDivider(color = MaterialTheme.colorScheme.onSurface)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .alpha(0.5f)
        ) {
            Text(text = "By using the app, you accept our Terms of Service",
                style = AppTypography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(text = "and acknowledge reading the Privacy Policy",
                style = AppTypography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Row(
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextButton(onClick = privacyOnClick) {
                Text(
                    text = stringResource(id = R.string.privacy_policy),
                    style = AppTypography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            VerticalDivider(modifier = Modifier.height(12.dp))
            TextButton(onClick = termServiceOnClick) {
                Text(
                    text = stringResource(id = R.string.terms_services),
                    style = AppTypography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomBarSignInPreview() {
    FootSignIn(privacyOnClick = { /*TODO*/ }, termServiceOnClick = { /*TODO*/ })
}