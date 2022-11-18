package com.gh0stnet.employeecontacts.feature_contacts.domain.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.Exception


@Entity(tableName = "people")

@Parcelize
data class People(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    var firstName: String,
    var lastName: String,
    val email: String,
    val phoneNumber: String,
    val address: String,
    val city: String,
    val state: String,
    val postcode: String,
    val dept: String

) : Parcelable

class InvalidContactException(message: String): Exception(message)
