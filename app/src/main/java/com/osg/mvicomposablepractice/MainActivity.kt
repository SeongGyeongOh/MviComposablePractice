package com.osg.mvicomposablepractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.osg.mvicomposablepractice.data.api.ApiHelperImpl
import com.osg.mvicomposablepractice.data.api.RetrofitBuilder
import com.osg.mvicomposablepractice.ui.main.viewmodel.MainViewModel
import com.osg.mvicomposablepractice.ui.main.viewstate.MVIJetpackComposeViewState
import com.osg.mvicomposablepractice.util.ViewModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi

//목표 : 간단한 recyclerview를 보여주는 예제를 만들어 보자
//1. Composable 사용
//2. MVI 패턴 사용
//3. Moshi 라이브러리 사용

//참고 코드
//mvi : https://blog.mindorks.com/mvi-architecture-android-tutorial-for-beginners-step-by-step-guide
//jetpack compose : https://medium.com/swlh/android-mvi-with-jetpack-compose-b0890f5156ac
//live data : https://medium.com/@fluxtah/another-way-of-using-livedata-with-jetpack-compose-77a28c287af9

@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

    @kotlinx.coroutines.ExperimentalCoroutinesApi
    lateinit var myViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        myViewModel = ViewModelProvider(this, ViewModelFactory(ApiHelperImpl(RetrofitBuilder.apiService))).get(MainViewModel::class.java)
        setContent {
            Column() {

            }
        }
    }
}

//@Composable
//fun <T> observe(data: LiveData<T>, block: ObserveScope<T>.() -> Unit) {
//    onActive {
//        val context = ObserveScope<T>()
//        block(context)
//        context.onStartBlock()
//
//        val observer = object : Observer<T> {
//            override fun onChanged(t: T) {
//                val resultScope = ObserveScope.OnResultScope(this, data, t)
//                context.onResultBlock(resultScope)
//            }
//        }
//
//        with(data) {
//            observeForever(observer)
//            onDispose {
//                removeObserver(observer)
//            }
//        }
//    }
//}
//
//class ObserveScope<T> {
//    internal var onStartBlock: () -> Unit = {}
//    fun onStart(block: () -> Unit) {
//        onStartBlock = block
//    }
//
//    internal var onResultBlock: OnResultScope<T>.() -> Unit = {}
//    fun onResult(block: OnResultScope<T>.() -> Unit) {
//        onResultBlock = block
//    }
//
//    class OnResultScope<T>(
//        private val observer: Observer<T>,
//        private val data: LiveData<T>,
//        val result: T
//    ) {
//        fun stopObserving() {
//            data.removeObserver(observer)
//        }
//    }
//}

//@Composable
//fun Dummy(model:MainViewModel){
//    val viewState = observe(data =model.jetpackComposeViewState, ObserveScope )
//}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MviComposablePracticeTheme {
//    }
//}