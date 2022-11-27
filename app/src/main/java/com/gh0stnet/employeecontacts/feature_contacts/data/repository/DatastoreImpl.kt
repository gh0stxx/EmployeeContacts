package com.gh0stnet.employeecontacts.feature_contacts.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.gh0stnet.employeecontacts.feature_contacts.domain.repository.DatastoreRepo
import kotlinx.coroutines.flow.first
import javax.inject.Inject

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name="DATASTORE")

class DatastoreImpl @Inject constructor(
    private val context: Context
): DatastoreRepo {
    override suspend fun storePref(key: String, value: Boolean) {

       val prefKey =  booleanPreferencesKey(key)
        context.dataStore.edit {
            it[prefKey] = value
        }
    }

    override suspend fun getPref(key: String): Boolean? {
       return try {
           val prefKey =  booleanPreferencesKey(key)
           val pref = context.dataStore.data.first()
           pref[prefKey]
       }catch (e:Exception) {
           e.stackTrace
           null
       }
    }

    override suspend fun clearPref(key: String) {
        TODO("Not yet implemented")
    }
}