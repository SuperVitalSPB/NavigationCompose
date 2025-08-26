package com.supervital.core.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.supervital.core.di.scope.DataScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

// @Module
// @InstallIn(SingletonComponent::class)
class NetworkModule {

    // @Provides
    fun provideGson(): Gson = GsonBuilder().serializeNulls().create()

    // @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectionPool(ConnectionPool())
            connectTimeout(90, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)

        }.build()
    }
}