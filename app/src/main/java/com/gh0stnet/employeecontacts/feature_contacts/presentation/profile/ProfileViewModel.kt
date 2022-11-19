package com.gh0stnet.employeecontacts.feature_contacts.presentation.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gh0stnet.employeecontacts.feature_contacts.domain.use_case.ContactUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val contactUseCases: ContactUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel(){
    private var currentContactId: Int? = null



    init {
        savedStateHandle.get<Int>("contactId")?.let { contactId ->
            if (contactId != -1) {
                viewModelScope.launch {
                    contactUseCases.getContact(contactId)?.also { contact ->
                        currentContactId = contact.id
                    }
                }
            }
        }
    }
}
