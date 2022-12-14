package com.gh0stnet.employeecontacts

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ContactApp : Application() {

    // theme toggle backend
    val isDark = mutableStateOf(true)
    val isBigger = mutableStateOf(false)

    fun toggleFontSize() {
        isBigger.value = !isBigger.value
    }
    fun toggleTheme() {
        isDark.value = !isDark.value
    }
}
