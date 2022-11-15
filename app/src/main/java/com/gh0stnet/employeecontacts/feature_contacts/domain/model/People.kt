package com.gh0stnet.employeecontacts.feature_contacts.domain.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.Exception


@Entity(tableName = "people")

@Parcelize
data class People(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val address: String,
    val state: String,
    val country: String,
    val dept: String
) : Parcelable

class InvalidContactException(message: String): Exception(message)
