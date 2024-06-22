package com.example.firebasetutorialjetpackcompose.firebase.screen.firestore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.firebasetutorialjetpackcompose.firebase.screen.first_screen.CardComponent

@Composable
fun FireStoreScreen(
    firestoreViewmodel : FireStoreViewModel= hiltViewModel()
) {
    val getData = firestoreViewmodel.state.value

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
           Text(text = getData.name.toString())
           Text(text = getData.password.toString())
        }
    }
}