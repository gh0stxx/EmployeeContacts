package com.gh0stnet.employeecontacts.feature_contacts.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "dept")
data class Department(
    @PrimaryKey(autoGenerate = false)
    val dept: String
)