package com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DrawerValue
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts.components.ContactItem


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ContactScreen(viewModel: ContactViewModel) {
val materialBlue700= Color(0xFF1976D2)
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
            scaffoldState = scaffoldState,
            topBar = { TopAppBar(title = {Text("TopAppBar")},backgroundColor = materialBlue700)  },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = { FloatingActionButton(onClick = {}){
                Text("X")
            } },
            drawerContent = { Text(text = "drawerContent") },
            content = {
                Column(modifier = Modifier
                    .verticalScroll(rememberScrollState())) {
                    ContactItem()
                    ContactItem()
                    ContactItem()
                    ContactItem()
                    ContactItem()
                    ContactItem()
                    ContactItem()
                    ContactItem()
                    ContactItem()
                    ContactItem()
                    ContactItem()
                    ContactItem()
                    ContactItem()
                    ContactItem()
                    ContactItem()
                }
            }
           // bottomBar = { BottomAppBar(backgroundColor = materialBlue700) { Text("BottomAppBar") } }
    )

    }






