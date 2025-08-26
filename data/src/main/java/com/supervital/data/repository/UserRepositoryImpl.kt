package com.supervital.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.supervital.data.database.dao.UserDao
import com.supervital.data.mappers.map
import com.supervital.domain.model.UserInfo
import com.supervital.domain.repository.UserRepository

// Репозиторий содержит код, который вызывает методы DAO для выполнения операций с базой данных.
class UserRepositoryImpl(
    private val userDao : UserDao
): UserRepository {

    override fun getUsers(): LiveData<List<UserInfo>> {
        return userDao.getUsers().map {
            it.map { entry ->
                entry.map()
            }
        }
    }

    override suspend  fun getCountUsers(userName: String): Int {
        return userDao.getCountUsers(userName)
    }

    override suspend fun addUser(userInfo: UserInfo) {
        userDao.addUser (userInfo.map())
    }

    override suspend fun deleteUser(id: Int) {
        userDao.deleteUser(id)
    }



}