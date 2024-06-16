package com.example.firebasetutorialjetpackcompose.firebase

sealed class Resource<T>(var data : T? = null , val msg : String? = null ) {
     class Success<T>( data: T) :Resource<T>(data)
    class Failure<T>(msg: String?,data: T? = null) : Resource<T>(data,msg)
    class Loading<T>(data: T? = null) : Resource<T>(data)

}