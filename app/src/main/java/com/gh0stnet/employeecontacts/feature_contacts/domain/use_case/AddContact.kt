package com.gh0stnet.employeecontacts.feature_contacts.domain.use_case

import com.gh0stnet.employeecontacts.feature_contacts.domain.model.Department
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.InvalidContactException
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import com.gh0stnet.employeecontacts.feature_contacts.domain.repository.PeopleRepo
import java.util.Locale

class AddContact(
    private val repo: PeopleRepo
) {

    @Throws(InvalidContactException::class)
    suspend operator fun invoke(person: People) {

        if (person.firstName.isBlank()) {
            throw InvalidContactException("First name cannot be empty")
        }
        person.firstName = person.firstName.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.getDefault()
            ) else it.toString()
        }
        if (person.lastName.isBlank()) {
            throw InvalidContactException("Last name cannot be empty")
        }
        person.lastName = person.lastName.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.getDefault()
            ) else it.toString()
        }
        if (person.phoneNumber.isBlank()) {
            throw InvalidContactException("Phone number cannot be empty")
        }
        if (person.address.isBlank()) {
            throw InvalidContactException("Address cannot be empty")
        }
        if (person.state.isBlank()) {
            throw InvalidContactException("State cannot be empty")
        }
        if (person.postcode.isBlank()) {
            throw InvalidContactException("Country cannot be empty")
        }
        if (person.dept.isBlank()) {
            throw InvalidContactException("Department cannot be empty")
        }
        repo.insertContact(person)
        repo.insertDept(department = Department(person.dept))

    }
}
