package com.example.testplayground.di


import com.example.testplayground.local.PostsDao
import com.example.testplayground.local.UserDao
import com.example.testplayground.repository.UserDetailRepository
import com.example.testplayground.repository.UserRepository
import com.example.testplayground.service.UserDetailService
import com.example.testplayground.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    fun provideUsersService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }

    @Singleton
    @Provides
    fun provideUserRepository(
        userService: UserService,
        userDao: UserDao
    ): UserRepository {
        return UserRepository(
            usersService = userService,
            userDao = userDao
        )
    }

    @Singleton
    @Provides
    fun provideUsersDetailService(retrofit: Retrofit): UserDetailService {
        return retrofit.create(UserDetailService::class.java)
    }


    @Singleton
    @Provides
    fun provideUserDetailRepository(
        userDetailService: UserDetailService,
        postsDao: PostsDao
    ): UserDetailRepository {
        return UserDetailRepository(
            userDetailService = userDetailService,
            userPostsDao = postsDao
        )
    }
}