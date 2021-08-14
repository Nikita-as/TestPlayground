package com.example.testplayground.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_post")
data class UserPost(

    @SerializedName("userId") val userId: Int,

    @PrimaryKey(autoGenerate = false)
    @SerializedName("id") val id: Int,

    @SerializedName("title") val title: String,

    @SerializedName("body") val body: String
)