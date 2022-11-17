package com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts

import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import com.gh0stnet.employeecontacts.feature_contacts.domain.util.PeopleOrder

sealed class ContactEvents {
    data class Order(val contactOrder: PeopleOrder) : ContactEvents()
    data class DeleteContact(val person: People) : ContactEvents()
    object RestoreContact: ContactEvents()

}
