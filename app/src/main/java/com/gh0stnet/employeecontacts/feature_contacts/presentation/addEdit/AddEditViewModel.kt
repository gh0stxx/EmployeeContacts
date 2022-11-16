package com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.gh0stnet.employeecontacts.feature_contacts.domain.use_case.ContactUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(
    private val contactUseCases: ContactUseCases
) : ViewModel() {

    var state by mutableStateOf(AddEditState())

}