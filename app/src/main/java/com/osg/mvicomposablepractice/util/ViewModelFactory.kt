package com.osg.mvicomposablepractice.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.osg.mvicomposablepractice.data.api.ApiHelper
import com.osg.mvicomposablepractice.data.repository.MainRepository
import com.osg.mvicomposablepractice.ui.main.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory (private val apiHelper: ApiHelper) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(p0: Class<T>): T {
        if(p0.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}