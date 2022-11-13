package com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import com.gh0stnet.employeecontacts.feature_contacts.domain.use_case.ContactUseCases
import com.gh0stnet.employeecontacts.feature_contacts.domain.util.OrderType
import com.gh0stnet.employeecontacts.feature_contacts.domain.util.PeopleOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val contactUseCases: ContactUseCases
) : ViewModel() {

    private var recentlyDeletedContacts: People? = null

    private var getContactJobs: Job? = null
    init {
        getContacts(PeopleOrder.Name(OrderType.Ascending))
    }

    private val _state = mutableStateOf<ContactsState>(ContactsState())
    val state: State<ContactsState> = _state

    fun onEvent(event: ContactEvents) {
        when (event) {
            is ContactEvents.Order -> {
                if (state.value.contactOrder::class == event.contactOrder::class &&
                    state.value.contactOrder.orderType == event.contactOrder.orderType
                ) {
                    return
                }
                getContacts(event.contactOrder)
            }


            is ContactEvents.DeleteContact -> {
                viewModelScope.launch {
                    contactUseCases.deleteContact(event.person)
                    recentlyDeletedContacts = event.person
                }
            }

            is ContactEvents.RestoreContact -> {
                viewModelScope.launch {
                    contactUseCases.addContact(recentlyDeletedContacts ?: return@launch)
                    recentlyDeletedContacts = null
                }
            }
        }
    }

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