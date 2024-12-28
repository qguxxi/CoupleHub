package com.synth.couplehub

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.synth.couplehub.data.repository.ImageRepository
import com.synth.couplehub.ui.screen.home.HomeViewModel

class CoupleHubViewModelFactory(private val context:Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val imageRepository = ImageRepository(context)
            return HomeViewModel(imageRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}