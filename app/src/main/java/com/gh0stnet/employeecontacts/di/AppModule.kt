package com.gh0stnet.employeecontacts.di

import android.app.Application
import androidx.room.Room
import com.gh0stnet.employeecontacts.feature_contacts.data.data_source.PeopleDatabase
import com.gh0stnet.employeecontacts.feature_contacts.data.repository.PeopleRepoImpl
import com.gh0stnet.employeecontacts.feature_contacts.domain.repository.PeopleRepo
import com.gh0stnet.employeecontacts.feature_contacts.domain.use_case.AddContact
import com.gh0stnet.employeecontacts.feature_contacts.domain.use_case.ContactUseCases
import com.gh0stnet.employeecontacts.feature_contacts.domain.use_case.DeleteContact
import com.gh0stnet.employeecontacts.feature_contacts.domain.use_case.GetContact
import com.gh0stnet.employeecontacts.feature_contacts.domain.use_case.GetContacts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContactDatabase(app: Application) : PeopleDatabase {
        return Room.databaseBuilder(
            app,
            PeopleDatabase::class.java,
            PeopleDatabase.DATABASE_NAME
        ).createFromAsset("database/contact_db.db").build()
}

    @Provides
    @Singleton
    fun provideContactRepo(db: PeopleDatabase) : PeopleRepo {
        return  PeopleRepoImpl(db.contactDao)
    }

    @Provides
    @Singleton
    fun provideContactUseCases(repo: PeopleRepo): ContactUseCases {
        return ContactUseCases(
            getContacts = GetContacts(repo),
            deleteContact = DeleteContact(repo),
            addContact = AddContact(repo),
            getContact = GetContact(repo)
        )
    }
}