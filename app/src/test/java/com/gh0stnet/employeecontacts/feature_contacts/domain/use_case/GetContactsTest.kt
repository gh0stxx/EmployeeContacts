package com.gh0stnet.employeecontacts.feature_contacts.domain.use_case

import com.gh0stnet.employeecontacts.feature_contacts.data.repo.FakeRepo
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import com.gh0stnet.employeecontacts.feature_contacts.domain.util.OrderType
import com.gh0stnet.employeecontacts.feature_contacts.domain.util.PeopleOrder
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

import org.junit.Before
import org.junit.Test

class GetContactsTest {

    private lateinit var getContacts: GetContacts
    private lateinit var fakeRepo: FakeRepo

    @Before
    fun setUp() {
        fakeRepo = FakeRepo()
        getContacts = GetContacts(fakeRepo)

        val contactsToInsert = mutableListOf<People>()
        ('a'..'z').forEachIndexed { index, c ->
            contactsToInsert.add(
                People(
                    firstName = c.toString(),
                    lastName = c.toString(),
                    phoneNumber = c.toString(),
                    email = c.toString(),
                    address = c.toString(),
                    state = c.toString(),
                    postcode = c.toString(),
                    dept = c.toString(),
                    city = c.toString(),
                    id = index.toInt()
                    )

            )
        }
        contactsToInsert.shuffle()
        runBlocking {         contactsToInsert.forEach { fakeRepo.insertContact(it)}
 }
    }

    @Test
    fun `Order contacts by name correct order ascending`() = runBlocking {
        val contact = getContacts(PeopleOrder.Name(OrderType.Ascending)).first()

        for(i in 0..contact.size - 2) {
            assertThat(contact[i].firstName).isLessThan(contact[i+1].lastName)
        }
    }
    @Test
    fun `Order contacts by name correct order descending`() = runBlocking {
        val contact = getContacts(PeopleOrder.Name(OrderType.Descending)).first()

        for(i in 0..contact.size - 2) {
            assertThat(contact[i].firstName).isGreaterThan(contact[i+1].lastName)
        }
    }
}