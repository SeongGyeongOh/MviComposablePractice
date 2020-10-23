package com.osg.mvicomposablepractice.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osg.mvicomposablepractice.data.repository.MainRepository
import com.osg.mvicomposablepractice.ui.main.intent.MainIntent
import com.osg.mvicomposablepractice.ui.main.viewstate.MVIJetpackComposeViewState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainViewModel (private val repository: MainRepository): ViewModel() {
    val useIntent = Channel<MainIntent>(Channel.UNLIMITED)
    private val _jetpackComposeViewState = MutableLiveData<MVIJetpackComposeViewState>()
    val jetpackComposeViewState : LiveData<MVIJetpackComposeViewState>
        get() = _jetpackComposeViewState

    init{
        loadData()
    }

    fun loadData(){
        viewModelScope.launch {
            useIntent.consumeAsFlow().collect {
                when(it){
                    is MainIntent.FetchUser -> fetchUser()
                }
            }
        }
    }

    fun fetchUser(){
        viewModelScope.launch {
            _jetpackComposeViewState.value = MVIJetpackComposeViewState.Loading
            _jetpackComposeViewState.value = try{
                MVIJetpackComposeViewState.Success(repository.getUsers().toString())
            }catch (e: Exception){
                MVIJetpackComposeViewState.Error(e.toString())
            }
        }
    }

}