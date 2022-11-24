package com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gh0stnet.employeecontacts.ContactApp
import com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts.components.ContactItem
import com.gh0stnet.employeecontacts.feature_contacts.presentation.destinations.AddEditScreenDestination
import com.gh0stnet.employeecontacts.ui.theme.LightGrey
import com.gh0stnet.employeecontacts.ui.theme.Red
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Destination(start = true)
@Composable
fun ContactScreen(
    navigator: DestinationsNavigator,
    viewModel: ContactViewModel = hiltViewModel(),
) {

    val state = viewModel.state.value
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Red, darkIcons = false
        )
    }

    Scaffold(Modifier.background(MaterialTheme.colorScheme.background), topBar = {
        TopAppBar(title = { Text("EOI Connect") }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Red, titleContentColor = LightGrey
        ), actions = {
            TopAppBarActionButton(
                imageVector = if(viewModel.app.isDark.value)
                    Icons.Outlined.DarkMode
                else
                    Icons.Outlined.LightMode
                ,
                description = "Toggle theme",
                app = viewModel.app
            )
        }
        )
    },

        floatingActionButtonPosition = FabPosition.End, floatingActionButton = {
            FloatingActionButton(
                onClick = { navigator.navigate(AddEditScreenDestination(user = null)) },
                containerColor = Red,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add contact")
            }
        }, content = { values ->

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp, 0.dp, 20.dp, 0.dp)
                    .background(color = MaterialTheme.colorScheme.background),
                contentPadding = values

            ) {
                items(state.contact) { contact ->
                    ContactItem(
                        person = contact, navigator = navigator,
                    )

                    Divider(color = MaterialTheme.colorScheme.surface, thickness = 0.2.dp)
                }
            }
        }
    )
}

@Composable
fun TopAppBarActionButton(
    imageVector: ImageVector, description: String, app: ContactApp
) {
    IconButton(
        onClick = {
            app.toggleTheme()

        }, colors = IconButtonDefaults.outlinedIconButtonColors(
            contentColor = LightGrey,
            //containerColor = MaterialTheme.colorScheme.surface
        )
    ) {

        Icon(imageVector = imageVector, contentDescription = description)
    }
}