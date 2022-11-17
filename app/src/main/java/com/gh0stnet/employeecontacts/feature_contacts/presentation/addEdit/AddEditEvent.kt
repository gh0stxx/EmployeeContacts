package com.gh0stnet.employeecontacts.feature_contacts.presentation.addEdit

sealed class AddEditEvent {
    data class EnteredFirstName(val value: String): AddEditEvent()
    data class EnteredLastName(val value: String): AddEditEvent()
    data class EnteredPhone(val value: String): AddEditEvent()
    data class EnteredEmail(val value: String): AddEditEvent()
    data class EnteredAddress(val value: String): AddEditEvent()
    data class EnteredState(val value: String): AddEditEvent()
    data class EnteredCountry(val value: String): AddEditEvent()
    data class EnteredDept(val value: String): AddEditEvent()
    object InsertContact: AddEditEvent()
}
