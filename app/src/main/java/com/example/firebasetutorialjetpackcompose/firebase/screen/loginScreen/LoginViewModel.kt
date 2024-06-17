package com.example.firebasetutorialjetpackcompose.firebase.screen.loginScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebasetutorialjetpackcompose.firebase.Resource
import com.example.firebasetutorialjetpackcompose.firebase.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {

    private val _loginState = Channel<LoginState>()
    val loginState = _loginState.receiveAsFlow()

    fun loginUser(email : String, password : String) = viewModelScope.launch {
        authRepository.loginUser(email, password).collect{result ->
            when(result){
                is Resource.Failure -> {
                    _loginState.send(LoginState(isError = result.msg))
                }
                is Resource.Loading -> {
                    _loginState.send(LoginState(isLoading = true))
                }
                is Resource.Success -> {
                    _loginState.send(LoginState(isSuccess = result.data.toString()))
                }
            }
        }
    }
}

data class LoginState(
    val isSuccess : String? = null,
    val isLoading : Boolean = false,
    val isError : String? = null
)