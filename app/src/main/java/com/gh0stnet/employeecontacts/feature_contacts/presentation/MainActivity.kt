package com.gh0stnet.employeecontacts.feature_contacts.presentation

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.gh0stnet.employeecontacts.ContactApp
import com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts.ContactViewModel
import com.gh0stnet.employeecontacts.ui.theme.EmployeeContactsTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@Suppress("DEPRECATION")
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var app: ContactApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)


        setContent {

            EmployeeContactsTheme(darkTheme = app.isDark.value) {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
