package com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gh0stnet.employeecontacts.feature_contacts.domain.use_case.ContactUseCases
import com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit.components.UserInput
import com.gh0stnet.employeecontacts.ui.theme.LightGrey
import com.gh0stnet.employeecontacts.ui.theme.Red
import com.ramcosta.composedestinations.annotation.Destination


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun AddEditScreen(

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
LaunchedEffect(key1 = context) {
    viewModel.validationEvents.collect { event ->
        when (event) {
            is AddEditViewModel.ValidationEvent.Success -> {
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
        topBar = {
            TopAppBar(
                title = { Text("Add Contact", color = LightGrey) },
                backgroundColor = Red
            )
        },


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
                        onEvent = { viewModel.onEvent(it)

                        },

                    )

                }
                Surface(
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .width(200.dp)
                ) {
                    Button(
                        onClick = { viewModel.onEvent(AddEditEvent.InsertContact) },
                        shape = RoundedCornerShape(30.dp),
                        colors = ButtonDefaults.buttonColors(Red),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
                        modifier = Modifier.padding(10.dp)
                    )


                    {
                        Text(text = "Submit")
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



)

{
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

            .padding(20.dp)
    ) {
        Spacer(modifier = Modifier.height(44.dp))
        UserInput(
            text = firstName,

            hint = "First Name",
            onTextChange = { onEvent(AddEditEvent.EnteredFirstName(it)) }, hasError = fnState)
        UserInput(
            text = lastName,
            hint = "Last Name",
            onTextChange = { onEvent(AddEditEvent.EnteredLastName(it)) }, hasError = lnState)

        UserInput(
            text = phone,
            hint = "Phone Number",
            onTextChange = { onEvent(AddEditEvent.EnteredPhone(it)) }, hasError = pState)
        UserInput(
            text = email,
            hint = "Email Address",
            onTextChange = { onEvent(AddEditEvent.EnteredEmail(it)) }, hasError = eState)
        UserInput(
            text = address,
            hint = "Address",
            onTextChange = { onEvent(AddEditEvent.EnteredAddress(it)) }, hasError = pState)
        UserInput(
            text = state,
            hint = "State",
            onTextChange = { onEvent(AddEditEvent.EnteredState(it)) }, hasError = sState)
        UserInput(
            text = country,
            hint = "Country",
            onTextChange = { onEvent(AddEditEvent.EnteredCountry(it)) }, hasError = cState)
        UserInput(
            text = dept,
            hint = "Department",
            onTextChange = { onEvent(AddEditEvent.EnteredDept(it)) }, hasError = dState)

    }
}
