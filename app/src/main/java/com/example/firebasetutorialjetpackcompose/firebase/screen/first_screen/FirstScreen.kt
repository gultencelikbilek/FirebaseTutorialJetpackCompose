package com.example.firebasetutorialjetpackcompose.firebase.screen.first_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun FirstScreen(navController: NavController) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CardComponent("Login", onClick = {
                navController.navigate("login_screen")
            })
            Spacer(modifier = Modifier.width(20.dp))
            CardComponent("Create Account",onClick = {
                navController.navigate("create_account_screen")
            })

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevFirstScreen() {
    val navController= rememberNavController()
    FirstScreen(navController = navController)
}