package com.gh0stnet.employeecontacts.feature_contacts.domain.use_case

data class ContactUseCases (
    val getContacts: GetContacts,
    val deleteContact: DeleteContact,
    val addContact: AddContact
)