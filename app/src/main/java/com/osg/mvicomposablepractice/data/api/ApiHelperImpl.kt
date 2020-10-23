package com.osg.mvicomposablepractice.data.api

import com.osg.mvicomposablepractice.data.model.User

class ApiHelperImpl (private val apiService: ApiService) : ApiHelper{
    override suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }
}