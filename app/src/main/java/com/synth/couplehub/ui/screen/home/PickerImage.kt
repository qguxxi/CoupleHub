package com.synth.couplehub.ui.screen.home


import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.synth.couplehub.R
import com.synth.couplehub.ui.theme.mediumRoundedCornerShape

@Composable
fun PickerImage(clickImage: () -> Unit , uri: Uri? ,isSelected : Boolean, modifier : Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(300.dp)
            .height(200.dp)
            .clip(mediumRoundedCornerShape)
            .background(MaterialTheme.colorScheme.surfaceContainer , shape = mediumRoundedCornerShape)
            .clickable(onClick = clickImage)
    ) {
        if (isSelected)
            AsyncImage(model = uri , contentDescription = "image", contentScale = ContentScale.Crop)
        else Icon(painter = painterResource(id = R.drawable.add) , contentDescription = "add image", tint = Color.Unspecified)
    }
}