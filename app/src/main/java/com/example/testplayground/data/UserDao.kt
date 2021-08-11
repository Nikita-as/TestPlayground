package com.example.testplayground.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testplayground.model.User
import com.example.testplayground.model.UserPost

@Dao
interface UserDao {

    @Query("SELECT * FROM user_data")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM user_data WHERE userId = :id")
    fun getUser(id: Int): LiveData<User>

    @Query("SELECT * FROM user_post")
    fun getAllUsersPosts(): LiveData<List<UserPost>>

    @Query("SELECT * FROM user_post WHERE userId = :id")
    fun getUserPost(id: Int): LiveData<UserPost>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(user: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)
}


/*  @Query("SELECT * FROM user_data ORDER BY id ASC")
  fun readAllData(): LiveData<List<User>>*/
