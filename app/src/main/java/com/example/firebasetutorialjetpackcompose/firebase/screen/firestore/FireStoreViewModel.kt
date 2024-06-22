package com.example.firebasetutorialjetpackcompose.firebase.screen.firestore

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebasetutorialjetpackcompose.firebase.auth.model.Users
import com.google.firebase.FirebaseException
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class FireStoreViewModel @Inject constructor(
    private val firebaseFirestore: FirebaseFirestore
) : ViewModel() {
    val state = mutableStateOf(Users())

    init {
        getData()
    }
    private  fun getData(){
        viewModelScope.launch {
            state.value = getDataFromFirebase(firebaseFirestore)
        }
    }
}
var users = Users()
suspend fun getDataFromFirebase(firebaseFirestore: FirebaseFirestore): Users {
    try {
        firebaseFirestore.collection("users").get().await().map {
            val result = it.toObject(Users::class.java)
            users = result
        }
    } catch (e: FirebaseException) {
        Log.d("error","getDataFromFirestore: $e")
    }
    return users
}
