package com.supervital.data.di

import android.content.Context
import androidx.room.Room
import com.supervital.core.di.scope.DataScope
import com.supervital.data.database.ContactsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

// @Module
// @InstallIn(SingletonComponent::class)
class ContactsDatabaseModule {

    // @DataScope
    // @Provides
    fun provideContactsDatabase(@ApplicationContext appContext: Context): ContactsDatabase {
        return Room.databaseBuilder(appContext, ContactsDatabase::class.java, CONTACTS_DB)
            .build()
    }

    // @DataScope
    // @Provides
    fun provideUserDao(dataBase: ContactsDatabase) = dataBase.userDao()

    companion object {
        const val CONTACTS_DB = "contacts.db"
    }

}