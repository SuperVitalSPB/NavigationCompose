package com.supervital.navigationcompose

import android.app.Application
import com.supervital.core.di.CoreComponent
// import com.supervital.core.di.DaggerCoreComponent
import com.supervital.core.di.module.ContextModule
import com.supervital.core.di.module.NetworkModule
import com.supervital.data.di.ContactsDataComponent
// import com.supervital.data.di.DaggerContactsDataComponent
import com.supervital.navigationcompose.di.AppComponent
// import com.supervital.navigationcompose.di.DaggerAppComponent
import dagger.hilt.android.HiltAndroidApp

// @HiltAndroidApp
class App : Application() {

//    lateinit var appComponent: AppComponent
/*
    lateinit var coreComponent: CoreComponent
    lateinit var dataComponent: ContactsDataComponent
*/

    override fun onCreate() {
        super.onCreate()
//        appComponent = DaggerAppComponent.create()
/*
        coreComponent = DaggerCoreComponent.builder()
           // .networkModule(NetworkModule())
            .build()
        dataComponent = DaggerContactsDataComponent.create()
*/


    }

}