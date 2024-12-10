package com.synth.couplehub.ui.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.synth.couplehub.ui.viewmodel.SharedViewModel

@Composable
fun HomeScreen(sharedViewModel : SharedViewModel,modifier : Modifier = Modifier) {
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(sharedViewModel = SharedViewModel())
}

