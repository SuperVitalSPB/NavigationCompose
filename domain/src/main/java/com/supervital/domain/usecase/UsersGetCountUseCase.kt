package com.supervital.domain.usecase

import com.supervital.domain.repository.UserRepository
import javax.inject.Inject

class UsersGetCountUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userName: String) = userRepository.getCountUsers(userName)
}