package com.example.testplayground.di


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
        userService: UserService
    ): UserRepository {
        return UserRepository(
            userService = userService

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
    ): UserDetailRepository {
        return UserDetailRepository(
            userDetailService = userDetailService
        )
    }
}