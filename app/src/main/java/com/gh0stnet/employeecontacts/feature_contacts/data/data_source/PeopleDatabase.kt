package com.gh0stnet.employeecontacts.feature_contacts.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People

@Database(
    entities = [People::class],
    version = 1
)
abstract class PeopleDatabase : RoomDatabase() {

    abstract val contactDao: ContactDao

    companion object {
        const val DATABASE_NAME = "contact_db"
    }
}