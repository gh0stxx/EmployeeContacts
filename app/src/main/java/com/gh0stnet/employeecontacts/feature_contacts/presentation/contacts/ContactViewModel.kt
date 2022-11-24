package com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gh0stnet.employeecontacts.ContactApp
import com.gh0stnet.employeecontacts.feature_contacts.domain.use_case.ContactUseCases
import com.gh0stnet.employeecontacts.feature_contacts.domain.util.OrderType
import com.gh0stnet.employeecontacts.feature_contacts.domain.util.PeopleOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val contactUseCases: ContactUseCases,
    val app: ContactApp,
) : ViewModel() {

    private var getContactJobs: Job? = null



    init {
        getContacts(PeopleOrder.Name(OrderType.Ascending))
    }

    private val _state = mutableStateOf(ContactsState())
    val state: State<ContactsState> = _state


    private fun getContacts(contactOrder: PeopleOrder) {
        getContactJobs?.cancel()
        getContactJobs = contactUseCases.getContacts(contactOrder)
            .onEach { contacts ->
                _state.value = state.value.copy(
                    contact = contacts,
                    contactOrder = contactOrder
                )
            }
            .launchIn(
                viewModelScope
            )
    }
}
