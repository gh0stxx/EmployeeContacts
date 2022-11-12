package com.gh0stnet.employeecontacts.feature_contacts.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gh0stnet.employeecontacts.feature_contacts.domain.model.People
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Query("SELECT * FROM people")
    fun getContacts(): Flow<List<People>>

    @Query("SELECT * FROM people WHERE id = :id")
    suspend fun getContactById(id: Int): People?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(people: People)

    @Delete
    suspend fun deleteContact(people: People)
}