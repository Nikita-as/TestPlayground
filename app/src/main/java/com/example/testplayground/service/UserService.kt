package com.example.testplayground.service

import com.example.testplayground.model.User
import retrofit2.http.GET

interface UserService {
    @GET("/users")
    suspend fun getUser(): List<User>
}