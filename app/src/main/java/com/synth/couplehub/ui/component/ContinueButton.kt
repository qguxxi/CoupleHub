package com.synth.couplehub.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.synth.couplehub.R
import com.synth.couplehub.ui.theme.mediumRoundedCornerShape

@Composable
fun ContinueButton(enable: Boolean,onClick:() -> Unit,modifier : Modifier = Modifier) {
    Button(
        enabled = enable,
        onClick = onClick,
        shape = mediumRoundedCornerShape,
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceContainer,
            disabledContentColor = MaterialTheme.colorScheme.onSurface
        ) ,
        modifier = Modifier
            .height(48.dp)
            .width(280.dp)
        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(id = R.string.let))
        }
    }
}

@Preview
@Composable
private fun ContinueButtonPreview() {
    ContinueButton(false, {})
}