package com.example.firebasetutorialjetpackcompose.navigation

sealed class Screen(val route : String) {

    object CreateAccountScreen : Screen(route = "create_account_screen")
    object LoginScreen : Screen(route = "login_screen")
}