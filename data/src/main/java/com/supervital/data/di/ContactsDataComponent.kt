package com.supervital.data.di

import com.supervital.core.base.BaseComponent
import com.supervital.core.di.CoreComponent
import com.supervital.core.di.scope.DataScope
import com.supervital.data.database.ContactsDatabase
import com.supervital.domain.repository.UserRepository
import dagger.Component
import javax.inject.Singleton

/*
@DataScope
@Component (
    modules = [ContactsDatabaseModule::class, ContactsDataModule::class],
    dependencies = [CoreComponent::class]
)
*/
interface ContactsDataComponent /*: BaseComponent {

    fun contactsDatabase(): ContactsDatabase

    fun userRepository(): UserRepository
}*/