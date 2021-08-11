package com.example.testplayground.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_data")
data class User(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") val userId: Int,
    @SerializedName("name") val userName: String,
    @SerializedName("username") val userUserName: String,

    )