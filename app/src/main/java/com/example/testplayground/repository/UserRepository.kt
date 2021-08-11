package com.example.testplayground.repository

import com.example.testplayground.model.User
import com.example.testplayground.service.UserService
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userService: UserService

    ) {
    suspend fun fetchUserData(): List<User> {

        return userService.getUser()

    }


}