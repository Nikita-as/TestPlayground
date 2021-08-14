package com.example.testplayground.service

import com.example.testplayground.model.UserPost
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserDetailService {

    @GET("posts")
    fun getPosts(@Query("userId") userId: Int): Call<List<UserPost>>
}