package com.gh0stnet.employeecontacts.feature_contacts.domain.use_case

import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import com.gh0stnet.employeecontacts.feature_contacts.domain.repository.PeopleRepo

class GetContact(
    private val repo: PeopleRepo
) {
    suspend operator fun invoke(id: Int): People? {
        return repo.getContactById(id)
    }
}