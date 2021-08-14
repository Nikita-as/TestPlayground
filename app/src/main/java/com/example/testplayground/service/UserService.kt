package com.example.testplayground.service

import com.example.testplayground.model.User
import com.example.testplayground.model.UsersList
import com.example.testplayground.repository.UserRepository
import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("/users")
     fun getUser(): Call<UsersList>
}