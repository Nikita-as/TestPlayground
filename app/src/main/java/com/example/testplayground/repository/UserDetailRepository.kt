package com.example.testplayground.repository

import com.example.testplayground.local.PostsDao
import com.example.testplayground.model.UserPost
import com.example.testplayground.service.UserDetailService
import com.example.testplayground.useCases.Either
import com.example.testplayground.useCases.Failure
import com.example.testplayground.useCases.onNext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import javax.inject.Inject

class UserDetailRepository @Inject constructor(
    private val userDetailService: UserDetailService,
    private val userPostsDao: PostsDao
) {

    suspend fun fetchUserDetailData(userId: Int, needFetch: Boolean): Either<Failure, List<UserPost>> {
        return if (needFetch) {
            execute(userDetailService.getPosts(userId)) {
                it
            }.onNext {
                CoroutineScope(Dispatchers.IO).launch {
                    userPostsDao.insertPosts(it)
                }
            }
        } else {
            Either.Right(userPostsDao.getPosts())
        }
    }

    private fun <T : Any, R> execute(
        call: Call<T>,
        transform: (T) -> R
    ): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> Either.Right(transform(response.body()!!))
                false -> Either.Left(Failure.NetworkConnectionError)
            }
        } catch (exception: Throwable) {
            Either.Left(Failure.NetworkConnectionError)
        }
    }
}