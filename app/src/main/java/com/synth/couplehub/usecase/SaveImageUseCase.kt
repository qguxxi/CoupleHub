package com.synth.couplehub.usecase



import android.content.Context
import android.content.SharedPreferences

// Helper class để quản lý SharedPreferences
class CacheHelper(context: Context) {
    private val preferences: SharedPreferences = context.getSharedPreferences("app_cache", Context.MODE_PRIVATE)

    // Lưu đường dẫn ảnh
    fun saveImagePath(path: String) {
        preferences.edit().putString("image_path", path).apply()
    }

    // Lấy đường dẫn ảnh
    fun getImagePath(): String? {
        return preferences.getString("image_path", null)
    }
}