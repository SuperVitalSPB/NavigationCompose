package com.supervital.domain.usecase

import com.supervital.domain.repository.UserRepository
import javax.inject.Inject

class UsersListUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke() = userRepository.getUsers()
}