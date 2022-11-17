package com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import com.gh0stnet.employeecontacts.feature_contacts.domain.use_case.ContactUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(
    private val contactUseCases: ContactUseCases,
) : ViewModel() {

    var state by mutableStateOf(AddEditState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()
        fun onEvent(event: AddEditEvent) {
        when (event) {
            is AddEditEvent.EnteredFirstName -> {
                state = state.copy(firstName = event.value)
            }
            is AddEditEvent.EnteredLastName -> {
                state = state.copy(lastName = event.value)
            }

            is AddEditEvent.EnteredPhone -> {
                state = state.copy(phone = event.value)
            }
            is AddEditEvent.EnteredEmail -> {
                state = state.copy(email = event.value)
            }
            is AddEditEvent.EnteredAddress -> {
                state = state.copy(address = event.value)
            }
            is AddEditEvent.EnteredState -> {
                state = state.copy(sstate = event.value)
            }
            is AddEditEvent.EnteredCountry -> {
                state = state.copy(country = event.value)
            }
            is AddEditEvent.EnteredDept -> {
                state = state.copy(dept = event.value)
            }
            AddEditEvent.InsertContact -> {
                submit()
            }
        }
    }

    private fun submit() {

        val firstNameResult = contactUseCases.validateFirstName.execute(state.firstName)
        val lastNameResult = contactUseCases.validateLastName.execute(state.lastName)
        val emailResult = contactUseCases.validateEmail.execute(state.email)
        val phoneResult = contactUseCases.validatePhone.execute(state.phone)
        val addressResult = contactUseCases.validateAddress.execute(state.address)
        val stateResult = contactUseCases.validateState.execute(state.sstate)
        val countryResult = contactUseCases.validateCountry.execute(state.country)
        val deptResult = contactUseCases.validateDept.execute(state.dept)

        val hasError = listOf(
            firstNameResult,
            lastNameResult,
            emailResult,
            phoneResult,
            addressResult,
            stateResult,
            countryResult,
            deptResult
        ).any {
            !it.success
        }

        if(hasError) {
            state = state.copy(
                firstNameError = firstNameResult.errorMessage,
                lastNameError = lastNameResult.errorMessage,
                phoneError = phoneResult.errorMessage,
                emailError = emailResult.errorMessage,
                addressError = addressResult.errorMessage,
                stateError = stateResult.errorMessage,
                countryError = countryResult.errorMessage,
                deptError = deptResult.errorMessage
            )
            return
        }

        viewModelScope.launch {
            contactUseCases.addContact(
                People(
                    firstName = state.firstName,
                    lastName = state.lastName,
                    phoneNumber = state.phone,
                    email = state.email,
                    address = state.address,
                    state = state.sstate,
                    country = state.country,
                    dept = state.dept,
                    id = null
                )
            )
                        validationEventChannel.send(ValidationEvent.Success)
        }
    }
sealed class ValidationEvent {
        object Success: ValidationEvent()
    }
}
