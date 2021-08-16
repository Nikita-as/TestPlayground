package com.example.testplayground.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testplayground.model.User
import com.example.testplayground.useCases.Failure
import com.example.testplayground.useCases.GetAllUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val getAllUsersUseCase: GetAllUsersUseCase) :
    ViewModel() {


    val readAllData: MutableLiveData<List<User>> = MutableLiveData()
    private val failureData: MutableLiveData<Failure> = MutableLiveData()

    fun getAllUser(needFetch: Boolean) {
        getAllUsersUseCase(GetAllUsersUseCase.Params(needFetch)) {
            it.fold(::handleFailure) { users -> handleUsers(users, !needFetch) }
        }
    }

    private fun handleUsers(users: List<User>, fromCache: Boolean) {
        readAllData.value = users
        if (fromCache) getAllUser(needFetch = true)


    }

    private fun handleFailure(failure: Failure) {
        failureData.value = failure


    }

}