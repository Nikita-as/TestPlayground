package com.example.testplayground.repository

import com.example.testplayground.model.UserPost
import com.example.testplayground.service.UserDetailService
import javax.inject.Inject

class UserDetailRepository @Inject constructor(private val userDetailService: UserDetailService) {


    suspend fun fetchUserDetailData(userId: Int): List<UserPost> {
        return userDetailService.getPosts(userId)
    }
}