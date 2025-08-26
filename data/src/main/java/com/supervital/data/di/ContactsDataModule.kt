package com.supervital.data.di

import com.supervital.core.base.BaseComponent
import com.supervital.core.di.scope.DataScope
import com.supervital.data.database.dao.UserDao
import com.supervital.data.repository.UserRepositoryImpl
import com.supervital.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// @Module
// @InstallIn(SingletonComponent::class)
class ContactsDataModule {

    // @DataScope
    // @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository =
        UserRepositoryImpl(userDao = userDao)

}

