package com.synth.couplehub.ui.screen.home


import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(context: Context) : ViewModel() {
    private val sharedPreferences = context.getSharedPreferences("image_prefs", Context.MODE_PRIVATE)
    private val _selectedImageUri = MutableStateFlow<Uri?>(null)
    val selectedImageUri: StateFlow<Uri?> = _selectedImageUri

    init {
        // Load the saved URI when the ViewModel is created
        val savedUriString = sharedPreferences.getString("selected_image_uri", null)
        _selectedImageUri.value = savedUriString?.let { Uri.parse(it) }
    }

    fun updateSelectedImageUri(uri: Uri?) {
        _selectedImageUri.value = uri
        // Save the URI to SharedPreferences
        viewModelScope.launch {
            sharedPreferences.edit().putString("selected_image_uri", uri?.toString()).apply()
        }
    }
}