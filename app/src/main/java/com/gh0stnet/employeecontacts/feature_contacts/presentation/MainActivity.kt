package com.gh0stnet.employeecontacts.feature_contacts.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts.ContactScreen
import com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts.ContactViewModel
import com.gh0stnet.employeecontacts.feature_contacts.presentation.util.Screen
import com.gh0stnet.employeecontacts.ui.theme.EmployeeContactsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmployeeContactsTheme {

                Surface(
                    color = MaterialTheme.colors.background
                ) {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = Screen.ContactScreen.route

                            ) {
                            composable(route = Screen.ContactScreen.route) {
                                val viewModel = hiltViewModel<ContactViewModel>()
                                ContactScreen(viewModel = viewModel)

                            }
                        }
                    }
                }
            }
        }
    }


