package com.gh0stnet.employeecontacts.feature_contacts.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.Exception

@Entity(tableName = "people")

data class People(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val address: String,
    val state: String,
    val country: String,
    val dept: String
)

class InvalidContactException(message: String): Exception(message)
