package com.supervital.core.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.google.gson.Gson
import com.supervital.core.base.BaseComponent
import com.supervital.core.di.module.ContextModule
import com.supervital.core.di.module.CoroutineDispatcherModule
import com.supervital.core.di.module.NetworkModule
import com.supervital.core.di.qualifier.DispatcherIO
import com.supervital.core.di.qualifier.DispatcherMain
import com.supervital.core.di.scope.DataScope
import dagger.Component
import kotlinx.coroutines.CoroutineDispatcher
import okhttp3.OkHttpClient
import javax.inject.Singleton
/*
@Singleton
@Component(
    modules = [
        ContextModule::class,
        CoroutineDispatcherModule::class,
       // NetworkModule::class
        ]
)*/
interface CoreComponent /*: BaseComponent {

    @DispatcherIO
    fun coroutineDispatcherIO(): CoroutineDispatcher

    @DispatcherMain
    fun coroutineDispatcherMain(): CoroutineDispatcher

 //   fun okHttpClient(): OkHttpClient

   // fun gson(): Gson
}*/