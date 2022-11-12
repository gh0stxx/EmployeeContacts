package com.gh0stnet.employeecontacts.feature_contacts.domain.repository

import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import kotlinx.coroutines.flow.Flow

interface PeopleRepo {

    fun getContact(): Flow<List<People>>

    suspend fun getContactById(id: Int): People?

    suspend fun insertContact(people: People)

    suspend fun deleteContact(people: People)

}