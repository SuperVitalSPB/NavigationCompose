package com.supervital.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.supervital.data.database.dao.UserDao
import com.supervital.data.database.entries.UserEntry

/*
    База данных Room
    Представляет слой поверх фактической базы данных SQLite,
    который отвечает за предоставление доступа к экземплярам DAO.
    Каждое приложение Android должно иметь только один экземпляр базы данных Room
*/
@Database(entities = [(UserEntry::class)], version = 1)
abstract class UserRoomDatabase : RoomDatabase() {
    abstract val userDao: UserDao

    companion object {
        // Singleton базы данных Room
        fun getInstance(context: Context): UserRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserRoomDatabase::class.java,
                        "usersdb"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }

                return instance
            }
        }

        private var INSTANCE: UserRoomDatabase? = null
    }
}