package com.example.firebasetutorialjetpackcompose.navigation

sealed class Screen(val route : String) {

    object CreateAccountScreen : Screen(route = "create_account_screen")
    object LoginScreen : Screen(route = "login_screen")
    object FirstScreen : Screen(route = "first_screen")
    object LoginCreateAccountScreen : Screen(route = "login_create_account_screen")
}