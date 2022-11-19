package com.gh0stnet.employeecontacts.feature_contacts.domain.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.Department
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People

data class PeopleWithDepartment(
    @Embedded val department: Department,
    @Relation(
        parentColumn = "dept",
        entityColumn = "dept"
    )
    val people: List<People>
)
