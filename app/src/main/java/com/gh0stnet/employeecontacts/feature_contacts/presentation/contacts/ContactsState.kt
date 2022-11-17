package com.gh0stnet.employeecontacts.feature_contacts.presentation.contacts

import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import com.gh0stnet.employeecontacts.feature_contacts.domain.util.OrderType
import com.gh0stnet.employeecontacts.feature_contacts.domain.util.PeopleOrder

data class ContactsState(
    val contact: List<People> = emptyList(),
    val contactOrder: PeopleOrder = PeopleOrder.Name(OrderType.Ascending)
)
