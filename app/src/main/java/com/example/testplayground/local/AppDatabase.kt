package com.example.testplayground.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testplayground.model.User
import com.example.testplayground.model.UserPost

@Database(entities = [User::class, UserPost::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun postsDao(): PostsDao
}