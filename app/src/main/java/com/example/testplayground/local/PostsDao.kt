package com.example.testplayground.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testplayground.model.UserPost

@Dao
interface PostsDao {

    @Query("SELECT * FROM user_post")
    suspend fun getPosts(): List<UserPost>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPosts(posts: List<UserPost>)
}