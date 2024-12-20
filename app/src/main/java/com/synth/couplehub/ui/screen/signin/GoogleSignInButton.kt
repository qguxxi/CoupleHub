package com.synth.couplehub.ui.screen.signin

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.synth.couplehub.R
import com.synth.couplehub.ui.theme.AppTypography
import com.synth.couplehub.ui.theme.largeRoundedCornerShape

@Composable
fun GoogleSignInButton(onClick : () -> Unit ,isLoading:Boolean,modifier : Modifier = Modifier) {
    val scheme = MaterialTheme.colorScheme
    Button(
        onClick = onClick,
        shape = largeRoundedCornerShape ,
        colors = ButtonColors(scheme.primaryContainer,scheme.onPrimaryContainer,scheme.primaryContainer,scheme.primaryContainer) ,
        modifier = Modifier
            .height(54.dp)
            .width(280.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(1f)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            if (!isLoading) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.google) ,
                    contentDescription = "google" ,
                    tint = Color.Unspecified,
                )
            } else {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    color = scheme.onPrimaryContainer,
                    strokeWidth = 2.dp,
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = stringResource(id = R.string.google) ,
                style = AppTypography.labelSmall.copy(fontSize = 14.sp) ,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GoogleButtonPreview() {
    GoogleSignInButton({}, false)
}