package com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit.components.UserInput
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.selects.whileSelect

@Composable
fun AddEditScreen(
    navigator: DestinationsNavigator,
    viewModel: AddEditViewModel = hiltViewModel()
) {
    val firstNameState = viewModel.firstName.value
    val lastNameState = viewModel.lastName.value
    val phoneState = viewModel.phone.value
    val addressState = viewModel.address.value
    val emailState = viewModel.email.value
    val stateState= viewModel.state.value
    val countryState = viewModel.country.value
    val deptState = viewModel.dept.value


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
                onEvent = { viewModel.onEvent(it)}
            )
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
        //ddUserInput(text = , hint = , onTextChange = )
    }
}
