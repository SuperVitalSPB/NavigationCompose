package com.supervital.core.di.module

import android.app.Application
import android.app.NotificationManager
import android.app.admin.DevicePolicyManager
import android.app.role.RoleManager
import android.content.ContentResolver
import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager
import android.os.Build
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import androidx.annotation.RequiresApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

// @Module
class ContextModule(private val application: Application) /*{

    @Singleton
    @Provides
    fun provideApplication() : Application = application

    @Singleton
    @Provides
    fun provideContext() : Context = application

    @Singleton
    @Provides
    fun provideConnectivityManager() : ConnectivityManager {
        return application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Singleton
    @Provides
    fun provideTelephonyManager() : TelephonyManager {
        return application.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    }

    @Singleton
    @Provides
    fun provideLocationManager() : LocationManager {
        return application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    @Singleton
    @Provides
    fun provideNotificationManager() : NotificationManager {
        return application.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    @Singleton
    @Provides
    fun provideContentResolver() : ContentResolver {
        return application.contentResolver
    }

    @Singleton
    @Provides
    fun provideTelecomManager() : TelecomManager {
        return application.getSystemService(Context.TELECOM_SERVICE) as TelecomManager
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    @Singleton
    @Provides
    fun provideRoleManager() : RoleManager {
        return application.getSystemService(Context.ROLE_SERVICE) as RoleManager
    }

    @Singleton
    @Provides
    fun provideDevicePolicyManager() : DevicePolicyManager {
        return application.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
    }

}*/