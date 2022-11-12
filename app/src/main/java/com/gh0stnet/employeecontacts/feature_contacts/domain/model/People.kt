package com.gh0stnet.employeecontacts.feature_contacts.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class People(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val address: String,
    val state: String,
    val country: String,
    val dept: String,
    @PrimaryKey val id: Int? = null
)