package com.example.firebasetutorialjetpackcompose.firebase.auth

import com.example.firebasetutorialjetpackcompose.firebase.Resource
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun createUser(email : String, password : String):Flow<Resource<AuthResult>>

    fun loginUser(email: String,password: String) : Flow<Resource<AuthResult>>
}