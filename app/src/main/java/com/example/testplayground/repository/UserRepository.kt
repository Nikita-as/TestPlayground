package com.example.testplayground.repository

import androidx.lifecycle.LiveData
import com.example.testplayground.local.UserDao
import com.example.testplayground.model.User
import com.example.testplayground.model.UsersList
import com.example.testplayground.service.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao,
    private val userService: UserService

) {
    fun getAllUsers(): LiveData<List<User>> {
        return userDao.getAllUsers()
    }

    fun insertUser(user: User) {
        userDao.insertUsers(user)
    }

    fun makeApiCall() {

        val call: Call<UsersList> = userService.getUser()
        call?.enqueue(object : Callback<UsersList> {
            override fun onResponse(
                call: Call<UsersList>,
                response: Response<UsersList>
            ) {
                if(response.isSuccessful) {
                    userDao.deleteAllUsers()
                    response.body()?.items?.forEach {
                        insertUser(it)
                    }
                }
            }

            override fun onFailure(call: Call<UsersList>, t: Throwable) {
                //
            }
        })
    }



}