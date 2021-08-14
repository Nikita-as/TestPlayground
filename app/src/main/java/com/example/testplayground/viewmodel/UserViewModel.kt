package com.example.testplayground.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testplayground.model.User
import com.example.testplayground.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    val readAllData: MutableLiveData<List<User>> = MutableLiveData()

    private fun getAllUser() {

        viewModelScope.launch {
            val users = userRepository.fetchUserData()
            readAllData.value = users

        }
    }
    fun getAllUser(): LiveData<List<RepositoryData>> {
        return repository.getAllRecords()
    }

    init {
        getAllUser()
    }
    fun makeApiCall() {
      userRepository.makeApiCall()
    }


}