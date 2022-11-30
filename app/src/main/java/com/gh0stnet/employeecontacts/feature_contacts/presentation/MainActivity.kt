package com.gh0stnet.employeecontacts.feature_contacts.presentation

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import com.gh0stnet.employeecontacts.ContactApp
import com.gh0stnet.employeecontacts.feature_contacts.domain.repository.DatastoreRepo
import com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts.ContactViewModel
import com.gh0stnet.employeecontacts.ui.theme.EmployeeContactsTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@Suppress("DEPRECATION")
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val contactViewModel: ContactViewModel by viewModels()
    @Inject
    lateinit var app: ContactApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        app.isDark.value = contactViewModel.getTheme()
        setContent {

            //elvis operator needed for first run after install otherwise will crash with null reference
            //because datastore is empty, will be created after theme is toggled first time
            EmployeeContactsTheme(app.isDark.value == true) {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
