package com.osg.mvicomposablepractice.data.api

import com.osg.mvicomposablepractice.data.model.User

interface ApiHelper{
    suspend fun getUsers(): List<User>
}