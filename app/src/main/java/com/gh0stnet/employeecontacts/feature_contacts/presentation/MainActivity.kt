package com.gh0stnet.employeecontacts.feature_contacts.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.gh0stnet.employeecontacts.ui.theme.EmployeeContactsTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmployeeContactsTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }


}


