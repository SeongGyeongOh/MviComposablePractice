package com.osg.mvicomposablepractice.ui.main.viewstate

import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable

sealed class MVIJetpackComposeViewState{
    @Composable
    abstract fun buildUI()

    object IDLE :MVIJetpackComposeViewState(){
        @Composable
        override fun buildUI() {
            Text(text = "아무것도 안하는 중! 디폴트 상태~")
        }
    }

    object Loading : MVIJetpackComposeViewState(){
        @Composable
        override fun buildUI(){
            Text(text = "로딩중")
        }
    }

    class Error(private val reason: String) : MVIJetpackComposeViewState(){
        @Composable
        override fun buildUI() {
            Text(text = reason)
        }
    }

    class Success(private val body: String) :MVIJetpackComposeViewState() {
        @Composable
        override fun buildUI() {
            //여기서 recyclerview의 형태가 나타나야 함!!
            Text(text = body)
        }
    }
}