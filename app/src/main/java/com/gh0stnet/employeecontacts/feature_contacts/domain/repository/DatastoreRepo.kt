package com.gh0stnet.employeecontacts.feature_contacts.domain.repository

interface DatastoreRepo {

    suspend fun storePref(key:String, value: Boolean)
    suspend fun getPref(key:String): Boolean?
    suspend fun clearPref(key: String)
}