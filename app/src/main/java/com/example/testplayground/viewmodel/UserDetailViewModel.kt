package com.example.testplayground.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testplayground.model.UserPost
import com.example.testplayground.useCases.Failure
import com.example.testplayground.useCases.GetPostsByUserIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsByUserIdUseCase
) : ViewModel() {

    val posts: MutableLiveData<List<UserPost>> = MutableLiveData()
    private val failureData: MutableLiveData<Failure> = MutableLiveData()

    fun getPosts(userId: Int, needFetch: Boolean) {
        getPostsUseCase(GetPostsByUserIdUseCase.Params(userId, needFetch)) {
            it.fold(::handleFailure) { posts -> handlePosts(userId, posts, !needFetch) }
        }
    }

    private fun handlePosts(userId: Int, posts: List<UserPost>, fromCache: Boolean) {
        val currentUserPosts = posts.filter {
            it.userId == userId
        }
        this.posts.value = currentUserPosts
        if (fromCache) getPosts(userId = userId, needFetch = true)
    }

    private fun handleFailure(failure: Failure) {
        failureData.value = failure
    }
}