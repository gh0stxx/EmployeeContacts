package com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DrawerValue
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts.components.ContactItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ContactScreen(navController: NavController, viewModel: ContactViewModel = hiltViewModel()) {

    val state = viewModel.state.value
    val scope = rememberCoroutineScope()

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Red,
            darkIcons = false
        )
    }

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = { Text("TopAppBar") }, backgroundColor = Color.Red) },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                backgroundColor = Color.Red
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add contact")
            }
        },
        drawerContent = { Text(text = "drawerContent") },
        content = {

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.contact) { contact ->
                    ContactItem(person = contact, modifier = Modifier.fillMaxWidth())
                }
            }


        }

        // bottomBar = { BottomAppBar(backgroundColor = materialBlue700) { Text("BottomAppBar") } }
    )

}






