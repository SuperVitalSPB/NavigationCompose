package com.supervital.data.repository

import com.supervital.data.database.dao.UserDao
import com.supervital.data.mappers.map
import com.supervital.domain.model.UserInfo
import com.supervital.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Репозиторий содержит код, который вызывает методы DAO для выполнения операций с базой данных.
class UserRepositoryImpl(
    private val userDao : UserDao
): UserRepository {

    override fun getUsers(): Flow<List<UserInfo>> {
        return userDao.getUsers().map {
            it.map { entry ->
                entry.map()
            }
        }
    }

    override suspend  fun getCountUsers(userName: String): List<Int> {
        return userDao.getCountUsers(userName)
    }

    override suspend fun addUser(userInfo: UserInfo) {
        userDao.addUser (userInfo.map())
    }

    override suspend fun deleteUser(id: Int) {
        userDao.deleteUser(id)
    }



}