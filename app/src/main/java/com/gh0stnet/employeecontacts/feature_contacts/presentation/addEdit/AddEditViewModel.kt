package com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import com.gh0stnet.employeecontacts.feature_contacts.domain.use_case.AddContact
import com.gh0stnet.employeecontacts.feature_contacts.domain.use_case.GetContact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(
    private val getContact: GetContact,
    private val addContact: AddContact,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var _firstName = mutableStateOf(AddEditState())
    val firstName: State<AddEditState> = _firstName
    var _lastName = mutableStateOf(AddEditState())
    val lastName: State<AddEditState> = _lastName
    var _phone = mutableStateOf(AddEditState())
    val phone: State<AddEditState> = _phone
    var _address = mutableStateOf(AddEditState())
    val address: State<AddEditState> = _address
    var _email = mutableStateOf(AddEditState())
    val email: State<AddEditState> = _email
    var _state = mutableStateOf(AddEditState())
    val state: State<AddEditState> = _state
    var _country = mutableStateOf(AddEditState())
    val country: State<AddEditState> = _country
    var _dept = mutableStateOf(AddEditState())
    val dept: State<AddEditState> = _dept

    private var currentUserId: Int? = null

    init {
        savedStateHandle.get<Int>("userId")?.let { userId ->
            if (userId != -1) {
                viewModelScope.launch {
                    getContact(userId)?.also {user ->
                        currentUserId = user.id
                        _firstName.value = firstName.value.copy(
                        firstName = user.firstName
                        )
                         currentUserId = user.id
                        _lastName.value = lastName.value.copy(
                        lastName = user.lastName
                        )
                         currentUserId = user.id
                        _phone.value = phone.value.copy(
                        phone = user.phoneNumber
                        )
                        currentUserId = user.id
                        _email.value = email.value.copy(
                        email = user.email
                        )
                        currentUserId = user.id
                        _address.value = address.value.copy(
                        address = user.address
                        )
                        currentUserId = user.id
                        _state.value = state.value.copy(
                        state = user.state
                        )
                        currentUserId = user.id
                        _country.value = country.value.copy(
                        country = user.country
                        )
                        currentUserId = user.id
                        _dept.value = country.value.copy(
                        dept = user.dept
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: AddEditEvent) {
        when (event) {
            is AddEditEvent.EnteredFirstName -> {
                _firstName.value = firstName.value.copy(
                    firstName = event.value
                )
            }
            is AddEditEvent.EnteredLastName -> {
                _lastName.value = lastName.value.copy(
                    lastName = event.value
                )
            }
            is AddEditEvent.EnteredPhone -> {
                _phone.value = phone.value.copy(
                    phone = event.value
                )
            }
            is AddEditEvent.EnteredEmail -> {
                _email.value = email.value.copy(
                    email = event.value
                )
            }
            is AddEditEvent.EnteredAddress -> {
                _address.value = address.value.copy(
                    address = event.value
                )
            }
            is AddEditEvent.EnteredState -> {
                _state.value = state.value.copy(
                    state = event.value
                )
            }
            is AddEditEvent.EnteredCountry -> {
                _country.value = country.value.copy(
                    country = event.value
                    )
            }
            is AddEditEvent.EnteredDept -> {
                _dept.value = dept.value.copy(
                    dept = event.value
                )
            }
            AddEditEvent.InsertContact -> {
                viewModelScope.launch {
                    addContact(
                        People(
                            firstName = firstName.value.firstName,
                            lastName = lastName.value.lastName,
                            phoneNumber = phone.value.phone,
                            email = email.value.email,
                            address = address.value.address,
                            state = state.value.state,
                            country = country.value.country,
                            dept = dept.value.dept,
                            id = currentUserId
                        )
                    )
                }
            }
        }
    }
}