package com.example.testplayground.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testplayground.model.UserPost
import com.example.testplayground.repository.UserDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val userDetailRepository: UserDetailRepository
) : ViewModel() {

    val posts: MutableLiveData<List<UserPost>> = MutableLiveData()

    fun getUserPost(userId: Int) {
        viewModelScope.launch {
            val posts = userDetailRepository.fetchUserDetailData(userId)
            this@UserDetailViewModel.posts.value = posts
        }
    }
}