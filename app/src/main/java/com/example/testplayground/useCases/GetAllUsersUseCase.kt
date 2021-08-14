package com.example.testplayground.useCases

import com.example.testplayground.model.User
import com.example.testplayground.repository.UserRepository
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val repository: UserRepository
) : UseCase<List<User>, GetAllUsersUseCase.Params>() {
    override suspend fun run(params: Params) = repository.fetchUserData(params.needFetch)

    data class Params(val needFetch: Boolean)
}