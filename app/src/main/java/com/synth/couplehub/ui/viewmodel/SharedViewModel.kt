package com.synth.couplehub.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {
    private val _nameData = MutableStateFlow("")
    val sharedData: StateFlow<String> = _nameData

    private val _hornyName = MutableStateFlow("")
    val hornyName: StateFlow<String> = _hornyName

    fun setName(name: String) {
        _nameData.value = name
    }

    fun setHornyName(name: String) {
        _hornyName.value = name
    }



}