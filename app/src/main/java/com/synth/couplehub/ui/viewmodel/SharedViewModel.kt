package com.synth.couplehub.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SharedViewModel : ViewModel() {
    private val _nameData = MutableStateFlow("")
    val sharedData: StateFlow<String> = _nameData

    fun setName(name: String) {
        _nameData.value = name
    }


}