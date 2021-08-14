package com.example.testplayground.useCases

import com.example.testplayground.model.UserPost
import com.example.testplayground.repository.UserDetailRepository
import javax.inject.Inject

class GetPostsByUserIdUseCase @Inject constructor(
    private val repository: UserDetailRepository
) : UseCase<List<UserPost>, GetPostsByUserIdUseCase.Params>() {
    override suspend fun run(params: Params) = repository.fetchUserDetailData(params.userId, params.needFetch)

    data class Params(val userId: Int, val needFetch: Boolean)
}