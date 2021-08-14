package com.example.testplayground.repository

import com.example.testplayground.local.UserDao
import com.example.testplayground.model.User
import com.example.testplayground.service.UserService
import com.example.testplayground.useCases.Either
import com.example.testplayground.useCases.Failure
import com.example.testplayground.useCases.onNext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val usersService: UserService,
    private val userDao: UserDao
) {

    suspend fun fetchUserData(needFetch: Boolean): Either<Failure, List<User>> {
        return if (needFetch) {
            execute(usersService.getUsers()) {
                it
            }.onNext {
                CoroutineScope(Dispatchers.IO).launch {
                    userDao.insertUsers(it)
                }
            }
        } else {
            Either.Right(userDao.getAllUsers())

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