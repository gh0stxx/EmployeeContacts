package com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit.components.UserInput
import com.gh0stnet.employeecontacts.ui.theme.LightGrey
import com.gh0stnet.employeecontacts.ui.theme.Red
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun AddEditScreen(
        navigator: DestinationsNavigator,
    viewModel: AddEditViewModel = hiltViewModel(),
    ) {
    val firstNameState = viewModel.state.firstName
    val lastNameState = viewModel.state.lastName
    val phoneState = viewModel.state.phone
    val addressState = viewModel.state.address
    val emailState = viewModel.state.email
    val stateState = viewModel.state.sstate
    val countryState = viewModel.state.country
    val deptState = viewModel.state.dept
    val state = viewModel.state
    val context = LocalContext.current

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Red,
            darkIcons = false
        )
    }

    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is AddEditViewModel.ValidationEvent.Success -> {
                    navigator.navigateUp()
                    Toast.makeText(
                        context,
                        "Registration successful",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(
            title = { Text("Add Contact")},
            navigationIcon = {
                IconButton(onClick = {
                    navigator.navigateUp()
                }) {
                    Icon(Icons.Rounded.ArrowBack, "back arrow")
                }
            },
            backgroundColor = Red,
            contentColor = Color.White
        )},

        content = {

            Column(Modifier.verticalScroll(rememberScrollState())) {
                Surface {
                    EditContent(
                        firstName = firstNameState,
                        lastName = lastNameState,
                        address = addressState,
                        phone = phoneState,
                        email = emailState,
                        state = stateState,
                        country = countryState,
                        dept = deptState,
                        onEvent = {
                            viewModel.onEvent(it)
                        },
                    )
                }
                Surface(modifier = Modifier.fillMaxWidth()) {

                    Surface(
                        modifier = Modifier.padding(80.dp, 0.dp, 80.dp, 0.dp)
                    ) {
                        Button(
                            onClick = {
                                viewModel.onEvent(AddEditEvent.InsertContact)

                                      },
                            shape = RoundedCornerShape(30.dp),
                            colors = ButtonDefaults.buttonColors(Red),
                            elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                            modifier = Modifier.padding(10.dp)
                        )
                        {
                            Text(text = "Submit", fontWeight = FontWeight.Bold, color = Color.White)
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun EditContent(
    firstName: String,
    lastName: String,
    address: String,
    phone: String,
    email: String,
    state: String,
    country: String,
    dept: String,
    onEvent: (AddEditEvent) -> Unit,
) {
    val viewModel = viewModel<AddEditViewModel>()
    val fnState = viewModel.state.firstNameError
    val lnState = viewModel.state.lastNameError
    val pState = viewModel.state.phoneError
    val eState = viewModel.state.emailError
    val aState = viewModel.state.addressError
    val sState = viewModel.state.stateError
    val cState = viewModel.state.countryError
    val dState = viewModel.state.deptError

    Column(
        modifier = Modifier
            .fillMaxWidth()

            .padding(20.dp, 0.dp, 20.dp, 0.dp)
    ) {
        Spacer(modifier = Modifier.height(44.dp))
        UserInput(
            text = firstName,

            hint = "First Name",
            onTextChange = { onEvent(AddEditEvent.EnteredFirstName(it)) },
            hasError = fnState, keyboard = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        UserInput(
            text = lastName,
            hint = "Last Name",
            onTextChange = { onEvent(AddEditEvent.EnteredLastName(it)) },
            hasError = lnState, keyboard = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        UserInput(
            text = phone,
            hint = "Phone Number",
            onTextChange = { onEvent(AddEditEvent.EnteredPhone(it)) },
            hasError = pState, keyboard = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        UserInput(
            text = email,
            hint = "Email Address",
            onTextChange = { onEvent(AddEditEvent.EnteredEmail(it)) },
            hasError = eState, keyboard = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        UserInput(
            text = address,
            hint = "Address",
            onTextChange = { onEvent(AddEditEvent.EnteredAddress(it)) },
            hasError = aState, keyboard = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        UserInput(
            text = state,
            hint = "State",
            onTextChange = { onEvent(AddEditEvent.EnteredState(it)) },
            hasError = sState, keyboard = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        UserInput(
            text = country,
            hint = "Country",
            onTextChange = { onEvent(AddEditEvent.EnteredCountry(it)) },
            hasError = cState, keyboard = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        UserInput(
            text = dept,
            hint = "Department",
            onTextChange = { onEvent(AddEditEvent.EnteredDept(it)) },
            hasError = dState, keyboard = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
    }
}
