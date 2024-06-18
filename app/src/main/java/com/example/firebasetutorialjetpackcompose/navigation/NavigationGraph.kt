package com.example.firebasetutorialjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.firebasetutorialjetpackcompose.firebase.screen.createScreen.CreateAccountScreen
import com.example.firebasetutorialjetpackcompose.firebase.screen.first_screen.FirstScreen
import com.example.firebasetutorialjetpackcompose.firebase.screen.loginScreen.LoginScreen
import com.example.firebasetutorialjetpackcompose.firebase.screen.login_create_acc_screen.LoginCreateAccountScreen

@Composable
fun NavigationGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination =Screen.FirstScreen.route ){
        composable(route = Screen.CreateAccountScreen.route){
            CreateAccountScreen(navController)
        }
        composable(route = Screen.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(route = Screen.FirstScreen.route){
            FirstScreen(navController = navController)
        }
        composable(route = Screen.LoginCreateAccountScreen.route){
            LoginCreateAccountScreen()
        }
    }
}