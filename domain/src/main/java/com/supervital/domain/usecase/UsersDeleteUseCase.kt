package com.supervital.domain.usecase

import com.supervital.domain.model.UserInfo
import com.supervital.domain.repository.UserRepository
import javax.inject.Inject

class UsersDeleteUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(id: Int) = userRepository.deleteUser(id)
}