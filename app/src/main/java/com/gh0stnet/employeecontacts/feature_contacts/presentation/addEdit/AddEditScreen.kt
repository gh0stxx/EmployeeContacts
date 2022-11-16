package com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit.components.UserInput
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun AddEditScreen(

    viewModel: AddEditViewModel = hiltViewModel()
) {
    val firstNameState = viewModel.firstName.value
    val lastNameState = viewModel.lastName.value
    val phoneState = viewModel.phone.value
    val addressState = viewModel.address.value
    val emailState = viewModel.email.value
    val stateState = viewModel.state.value
    val countryState = viewModel.country.value
    val deptState = viewModel.dept.value

    Column() {


        Surface() {
            EditContent(
                firstName = firstNameState.firstName,
                lastName = lastNameState.lastName,
                address = addressState.address,
                phone = phoneState.phone,
                email = emailState.email,
                state = stateState.state,
                country = countryState.country,
                dept = deptState.dept,
                onEvent = { viewModel.onEvent(it) }
            )
        }
        Surface(modifier = Modifier.fillMaxWidth()) {
            Button(onClick =  { viewModel.onEvent(AddEditEvent.InsertContact)}) {

            }
        }

    }

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
    onEvent: (AddEditEvent) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(44.dp))
        UserInput(
            text = firstName,
            hint = "First Name",
            onTextChange = { onEvent(AddEditEvent.EnteredFirstName(it)) })
        UserInput(
            text = lastName,
            hint = "Last Name",
            onTextChange = { onEvent(AddEditEvent.EnteredLastName(it)) })
        UserInput(
            text = phone,
            hint = "Phone Number",
            onTextChange = { onEvent(AddEditEvent.EnteredPhone(it)) })
        UserInput(
            text = email,
            hint = "Email Address",
            onTextChange = { onEvent(AddEditEvent.EnteredEmail(it)) })
        UserInput(
            text = address,
            hint = "Address",
            onTextChange = { onEvent(AddEditEvent.EnteredAddress(it)) })
        UserInput(
            text = state,
            hint = "State",
            onTextChange = { onEvent(AddEditEvent.EnteredState(it)) })
        UserInput(
            text = country,
            hint = "Country",
            onTextChange = { onEvent(AddEditEvent.EnteredCountry(it)) })
        UserInput(
            text = dept,
            hint = "Department",
            onTextChange = { onEvent(AddEditEvent.EnteredDept(it)) })

        }
    }
