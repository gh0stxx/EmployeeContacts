package com.gh0stnet.employeecontacts.feature_contacts.data.repository

import com.gh0stnet.employeecontacts.feature_contacts.data.data_source.ContactDao
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import com.gh0stnet.employeecontacts.feature_contacts.domain.repository.PeopleRepo
import kotlinx.coroutines.flow.Flow

class PeopleRepoImpl(
    private  val dao: ContactDao
) : PeopleRepo {
    override fun getContact(): Flow<List<People>> {
        return dao.getContacts()
    }

    override suspend fun getContactById(id: Int): People? {
        return dao.getContactById(id)
    }

    override suspend fun insertContact(person: People) {
        dao.insertContact(person)
    }

    override suspend fun deleteContact(person: People) {
        dao.deleteContact(person)
    }
}