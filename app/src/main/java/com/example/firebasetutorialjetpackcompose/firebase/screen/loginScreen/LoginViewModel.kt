package com.example.firebasetutorialjetpackcompose.firebase.screen.loginScreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _loginState = MutableStateFlow(LoginState())
}

data class LoginState(
    val isSuccess : String? = null,
    val isLoading : Boolean = false,
    val isError : String? = null
)