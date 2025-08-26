package com.supervital.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.supervital.data.database.dao.UserDao
import com.supervital.data.database.entries.UserEntry

@Database(
    entities = [UserEntry::class],
    version = 1,
    exportSchema = false
)
abstract class ContactsDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}