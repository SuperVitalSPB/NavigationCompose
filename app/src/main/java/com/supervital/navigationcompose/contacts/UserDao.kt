package com.supervital.navigationcompose.contacts

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

// Объект доступа к данным или DAO (Data Access Object)
// предоставляет способ доступа к данным, хранящимся в базе данных SQLite
@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getUsers(): LiveData<List<User>>

    @Query("SELECT count(*) FROM users WHERE userName = :userName")
    fun getCountUsers(userName: String): List<Int>

    @Insert
    fun addUser(user: User)

    @Query("DELETE FROM users WHERE userId = :id")
    fun deleteUser(id: Int)
}