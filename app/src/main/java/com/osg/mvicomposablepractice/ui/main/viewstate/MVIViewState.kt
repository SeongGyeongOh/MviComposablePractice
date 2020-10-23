package com.osg.mvicomposablepractice.ui.main.viewstate

sealed class MVIViewState{
    object IDEL:MVIViewState()
    object Loading : MVIViewState()
    class Error(val reason: String): MVIViewState()
    class Success(val result: String): MVIViewState()
}