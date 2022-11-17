package com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts.components.ContactItem
import com.gh0stnet.employeecontacts.feature_contacts.presentation.destinations.AddEditScreenDestination
import com.gh0stnet.employeecontacts.feature_contacts.presentation.destinations.ProfileScreenDestination
import com.gh0stnet.employeecontacts.feature_contacts.presentation.util.Screen
import com.gh0stnet.employeecontacts.ui.theme.Charcoal
import com.gh0stnet.employeecontacts.ui.theme.Grey
import com.gh0stnet.employeecontacts.ui.theme.LightGrey
import com.gh0stnet.employeecontacts.ui.theme.Red
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination(start = true)
@Composable
fun ContactScreen(navigator: DestinationsNavigator, viewModel: ContactViewModel = hiltViewModel()) {

    val state = viewModel.state.value
    val scope = rememberCoroutineScope()

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Red,
            darkIcons = false
        )
    }

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = { Text("EOI Connect", color = LightGrey) }, backgroundColor = Red) },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navigator.navigate(AddEditScreenDestination)},
                backgroundColor = Red,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add contact")
            }
        },
        drawerContent = { Text(text = "drawerContent") },
        content = {

            LazyColumn(

                modifier = Modifier
                    .fillMaxSize()
                    .background(if (isSystemInDarkTheme()) Charcoal else Color.White)
                    .shadow(elevation = 1.dp)
                    .padding(15.dp,0.dp, 15.dp , 0.dp)

            ) {
                items(state.contact) { contact ->
                    ContactItem(
                        person = contact, modifier = Modifier.fillMaxWidth(),
                        navigator = navigator
                    )
                    if(isSystemInDarkTheme())
                        Divider(color = Grey, thickness = 1.dp, startIndent = Dp.Hairline)
                    else
                       Divider(color = LightGrey, thickness = 1.dp, startIndent = Dp.Hairline)
                }
            }
        }
    )
}