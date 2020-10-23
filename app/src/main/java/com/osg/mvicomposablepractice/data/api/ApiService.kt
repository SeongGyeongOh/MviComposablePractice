package com.osg.mvicomposablepractice.data.api

import com.osg.mvicomposablepractice.data.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}