package com.example.firebasetutorialjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.firebasetutorialjetpackcompose.firebase.screen.createScreen.CreateAccountScreen
import com.example.firebasetutorialjetpackcompose.firebase.screen.loginScreen.LoginScreen

@Composable
fun NavigationGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination =Screen.CreateAccountScreen.route ){
        composable(route = Screen.CreateAccountScreen.route){
            CreateAccountScreen(navController)
        }
        composable(route = Screen.LoginScreen.route){
            LoginScreen(navController)
        }
    }

}