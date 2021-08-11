package com.example.testplayground.service

import com.example.testplayground.model.UserPost
import retrofit2.http.GET
import retrofit2.http.Query

interface UserDetailService {

    @GET("posts")
    suspend fun getPosts(@Query("userId") userId: Int): List<UserPost>
}