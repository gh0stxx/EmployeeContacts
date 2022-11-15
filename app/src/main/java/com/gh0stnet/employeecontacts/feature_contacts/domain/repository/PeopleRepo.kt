package com.gh0stnet.employeecontacts.feature_contacts.domain.repository

import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import kotlinx.coroutines.flow.Flow

interface PeopleRepo {

    fun getContacts(): Flow<List<People>>

    suspend fun getContactById(id: Int): People?

    suspend fun insertContact(person: People)

    suspend fun deleteContact(person: People)



}