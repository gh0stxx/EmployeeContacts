package com.gh0stnet.employeecontacts

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ContactApp : Application() {

    val isDark = mutableStateOf(true)

    fun toggleTheme() {
        isDark.value = !isDark.value
    }
}
