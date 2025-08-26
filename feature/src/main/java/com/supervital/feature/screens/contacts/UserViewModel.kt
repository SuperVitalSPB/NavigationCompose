package com.supervital.feature.screens.contacts

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.supervital.domain.model.UserInfo
import com.supervital.domain.usecase.UsersCreateUseCase
import com.supervital.domain.usecase.UsersDeleteUseCase
import com.supervital.domain.usecase.UsersGetCountUseCase
import com.supervital.domain.usecase.UsersListUseCase
import com.supervital.feature.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

// @HiltViewModel
class UserViewModel
    @Inject
    constructor (
        private val application: Application,
        private val usersCreateUseCase: UsersCreateUseCase,
        private val usersDeleteUseCase: UsersDeleteUseCase,
        private val usersGetCountUseCase: UsersGetCountUseCase,
        private val usersListUseCase: UsersListUseCase) : ViewModel() {

    val userList = usersListUseCase()
    var userName = mutableStateOf("")
    var resultCheck = mutableStateOf(Any())
    var userAge = mutableStateOf("")
    private val _foundUsers = MutableLiveData<Boolean>()
    val foundUsers: LiveData<Boolean> = _foundUsers
    val getStringUserNameExists = application.getString(R.string.user_name_exists)

    fun changeName(value: String) {
        userName.value = value
        checkData()
        checkNameExists()
    }

    fun checkNameExists() {
        if (userName.value.isEmpty()) {
            _foundUsers.postValue(false)
            return
        }
        viewModelScope.launch (Dispatchers.IO ) {
            val isError = usersGetCountUseCase(userName.value) != 0
            _foundUsers.postValue(isError)
            if (isError && resultCheck.value is ResultCheck.ResultOk) {
                resultCheck.value = ResultCheck.NameExists()
            }
        }
    }

    fun changeAge(value: String) {
        if(value.isNotEmpty() && !value.isNumeric()) {
            return
        }
        userAge.value = value
        checkData()
    }

    fun checkData() {
        resultCheck.value = when {
            userName.value.isEmpty() -> ResultCheck.NameMustEnter()
            userAge.value.length == 0 || !userAge.value.isNumeric() -> ResultCheck.BadAge()
            else -> ResultCheck.ResultOk()
        }
    }

    fun addUser() {
        viewModelScope.launch {
            usersCreateUseCase(UserInfo(name = userName.value, age = userAge.value.toInt()))
        }
    }

    fun deleteUser(id: Int) {
        viewModelScope.launch {
            usersDeleteUseCase(id)
        }
    }
}

fun String.isNumeric(): Boolean {
    val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
    return this.matches(regex)
}
