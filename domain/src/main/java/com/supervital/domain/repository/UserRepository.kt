package com.supervital.domain.repository

import androidx.lifecycle.LiveData
import com.supervital.domain.model.UserInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

interface UserRepository {

    fun getUsers(): Flow<List<UserInfo>>

    suspend fun getCountUsers(userName: String): List<Int>

    suspend fun addUser(userInfo: UserInfo)

    suspend fun deleteUser(id: Int)

}