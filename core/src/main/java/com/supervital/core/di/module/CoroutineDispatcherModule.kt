package com.supervital.core.di.module

import com.supervital.core.di.qualifier.DispatcherIO
import com.supervital.core.di.qualifier.DispatcherMain
import com.supervital.core.di.scope.DataScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

// @Module
// @InstallIn(SingletonComponent::class)
class CoroutineDispatcherModule {

//    @DispatcherIO
    // @Provides
    fun provideCoroutineDispatcherIO(): CoroutineDispatcher = Dispatchers.IO

//    @DispatcherMain
    // @Provides
    fun provideCoroutineDispatcherMain(): CoroutineDispatcher = Dispatchers.Main

}