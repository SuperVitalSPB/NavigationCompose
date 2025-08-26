package com.supervital.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.supervital.data.database.entries.UserEntry

// Объект доступа к данным или DAO (Data Access Object)
// предоставляет способ доступа к данным, хранящимся в базе данных SQLite
@Dao
abstract class UserDao {
    @Query("SELECT * FROM users")
    abstract fun getUsers(): LiveData<List<UserEntry>>

    @Query("SELECT count(*) FROM users WHERE :userName is null or userName = :userName")
    abstract fun getCountUsers(userName: String): Int

    @Insert
    abstract suspend fun addUser(user: UserEntry)

    @Query("DELETE FROM users WHERE userId = :id")
    abstract suspend fun deleteUser(id: Int)
}