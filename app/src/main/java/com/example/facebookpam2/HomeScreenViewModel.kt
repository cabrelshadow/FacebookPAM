package com.example.facebookpam2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


sealed class HomeScreenState{
object Loading:HomeScreenState()
    data class Loaded(
        val avatarUrl:String,

    ):HomeScreenState()
    object SignInRequired:HomeScreenState()
}
class HomeScreenViewModel : ViewModel() {
private val mutableState= MutableStateFlow<HomeScreenState>(
  HomeScreenState.Loading
)
val state=mutableState.asStateFlow()
    init {
        viewModelScope.launch {
            //check for users signin

            mutableState.emit(
                HomeScreenState.SignInRequired
            )
        }
    }
}
