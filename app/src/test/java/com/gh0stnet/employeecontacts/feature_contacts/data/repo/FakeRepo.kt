package com.gh0stnet.employeecontacts.feature_contacts.data.repo

import com.gh0stnet.employeecontacts.feature_contacts.domain.model.Department
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import com.gh0stnet.employeecontacts.feature_contacts.domain.repository.PeopleRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRepo : PeopleRepo{

    private val contact = mutableListOf<People>()



    override fun getContacts(): Flow<List<People>> {
        return flow { emit(contact) }
    }

    override suspend fun getContactById(id: Int): People? {
        return contact.find { it.id == id }
    }

    override suspend fun insertContact(person: People) {
        contact.add(person)
    }

    override suspend fun insertDept(department: Department) {
      TODO()
    }

    override suspend fun deleteContact(person: People) {
        TODO("Not yet implemented")
    }
}