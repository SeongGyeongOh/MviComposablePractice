package com.osg.mvicomposablepractice.data.repository

import com.osg.mvicomposablepractice.data.api.ApiHelper

class MainRepository (private var apiHelper: ApiHelper){
    suspend fun getUsers() = apiHelper.getUsers()
}