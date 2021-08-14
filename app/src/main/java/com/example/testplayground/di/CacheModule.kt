package com.example.testplayground.di

import android.content.Context
import androidx.room.Room
import com.example.testplayground.local.AppDatabase
import com.example.testplayground.local.PostsDao
import com.example.testplayground.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "AppDatabase_Name").build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): UserDao {
        return db.userDao()
    }

    @Singleton
    @Provides
    fun providePostsDao(db: AppDatabase): PostsDao {
        return db.postsDao()
    }
}