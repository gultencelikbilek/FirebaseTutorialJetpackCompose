package com.example.firebasetutorialjetpackcompose.firebase.screen.createScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebasetutorialjetpackcompose.firebase.Resource
import com.example.firebasetutorialjetpackcompose.firebase.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateScreenViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _createState = Channel<CreateState>()
    val cretaeState = _createState.receiveAsFlow()

    fun createUser(email : String,password : String){
        viewModelScope.launch {
            authRepository.createUser(email,password).collect{result ->
                when(result){
                    is Resource.Failure -> {
                        _createState.send(CreateState(isError = "Error"))
                    }
                    is Resource.Loading -> {
                        _createState.send(CreateState(isLoading = true))
                    }
                    is Resource.Success -> {
                        _createState.send(CreateState(isSuccess = "Success"))
                    }
                }
            }
        }
    }


}

data class CreateState(
    val isSuccess : String? = null,
    val isLoading : Boolean = false,
    val isError : String? = null
)