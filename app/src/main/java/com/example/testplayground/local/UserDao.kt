package com.example.testplayground.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testplayground.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user_data")
    fun getAllUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: User)

    @Query("DELETE FROM user_data")
    fun deleteAllUsers()
}