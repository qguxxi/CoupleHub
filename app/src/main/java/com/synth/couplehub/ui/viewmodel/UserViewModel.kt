package com.synth.couplehub.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    var userName by mutableStateOf("")
        private set

    fun updateUserName(newName: String) {
        userName = newName
    }
}