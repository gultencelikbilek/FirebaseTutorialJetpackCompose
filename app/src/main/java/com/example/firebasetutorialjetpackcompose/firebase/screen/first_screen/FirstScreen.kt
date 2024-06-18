package com.example.firebasetutorialjetpackcompose.firebase.screen.first_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun FirstScreen(navController: NavController) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CardComponent(navController = navController,"Login")
        CardComponent(navController = navController,"Create Account")
        
    }
}

@Preview(showBackground = true)
@Composable
fun PrevFirstScreen() {
    val navController= rememberNavController()
    FirstScreen(navController = navController)
}