package com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.gh0stnet.employeecontacts.ContactApp
import com.gh0stnet.employeecontacts.R
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts.ContactViewModel
import com.gh0stnet.employeecontacts.feature_contacts.presentation.destinations.ProfileScreenDestination
import com.gh0stnet.employeecontacts.ui.theme.Charcoal
import com.gh0stnet.employeecontacts.ui.theme.LightGrey
import com.gh0stnet.employeecontacts.ui.theme.LightOrange
import com.gh0stnet.employeecontacts.ui.theme.Red
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun ContactItem(
    person: People,
    navigator: DestinationsNavigator,
    viewModel: ContactViewModel,
    app: ContactApp
) {
    var showDeleteConfirm by remember { mutableStateOf(false) }
    val trebuchetFont = FontFamily(
        Font(R.font.trebuc, FontWeight.Normal),
        Font(R.font.trebuc_bold, FontWeight.Bold)
    )

    if (showDeleteConfirm) {
        Column() {
            AlertDialog(

                onDismissRequest = { showDeleteConfirm = false },
                title = { Text(text = stringResource(R.string.delete_contact),
                    color = LightGrey,
                    fontWeight = FontWeight.Bold) },
                text = {
                    Text(
                        text = stringResource(R.string.delete_diag),
                        color = LightGrey,
                        fontSize = 16.sp,

                    )
                },
                confirmButton = {
                    Button(onClick = {
                        viewModel.delContact(person)
                        showDeleteConfirm = false
                    }, colors = ButtonDefaults.buttonColors(Charcoal)) {
                        Text(text = "Confirm", color = Color.White, fontSize = 14.sp)
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            showDeleteConfirm = false
                        },
                        colors = ButtonDefaults.buttonColors(Charcoal)
                    ) {
                        Text("Dismiss", color = Color.White, fontSize = 14.sp)
                    }
                },
                containerColor = Red,
                tonalElevation = 4.dp,
                properties = DialogProperties(decorFitsSystemWindows = true)
            )
        }
    }
    Card(
        Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .combinedClickable(
                onClick = {
                    navigator.navigate(
                        ProfileScreenDestination(
                            People(
                                firstName = person.firstName,
                                lastName = person.lastName,
                                state = person.state,
                                id = person.id,
                                address = person.address,
                                city = person.city,
                                postcode = person.postcode,
                                dept = person.dept,
                                phoneNumber = person.phoneNumber,
                                email = person.email
                            )
                        )
                    )
                },
                onLongClick = {
                    showDeleteConfirm = true
                }

            ), elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        border = BorderStroke(0.2.dp, if (app.isDark.value) Color.Black else LightGrey)
    ) {


        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shadowElevation = 5.dp,
                shape = RoundedCornerShape(0, 90, 90, 0),
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp)
            ) {
                Image(
                    painter = painter(person.id!!),
                    contentDescription = stringResource(R.string.PIC),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(104.dp)
                        .height(80.dp)
                        .clip(shape = RoundedCornerShape(0, 90, 90, 0))
                        .border(
                            0.1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(0, 90, 90, 0)
                        )
                )
            }
            Spacer(modifier = Modifier.size(15.dp))
            Column(
                modifier = Modifier.weight(weight = 0.8F)
            ) {
                Text(
                    text = "${person.firstName} ${person.lastName}",
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    letterSpacing = 1.5.sp,
                    fontFamily = trebuchetFont,
                )
                Text(
                    text = person.dept,
                    fontSize = 16.sp,
                    color = LightOrange,
                    fontFamily = trebuchetFont
                )
            }
        }
    }
}

@Composable
private fun painter(id: Int): Painter {

    return when (id) {
        1 -> painterResource(id = R.drawable.profile_pic11)
        2 -> painterResource(id = R.drawable.profile2)
        3 -> painterResource(id = R.drawable.profile_pic3)
        4 -> painterResource(id = R.drawable.profile4)
        6 -> painterResource(id = R.drawable.profile6)
        7 -> painterResource(id = R.drawable.profile_pic13)
        8 -> painterResource(id = R.drawable.profile8)
        9 -> painterResource(id = R.drawable.poppa)
        11 -> painterResource(id = R.drawable.baby)
        else -> painterResource(id = R.drawable.profile_pic1)
    }
}
