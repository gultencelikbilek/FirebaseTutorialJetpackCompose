package com.example.firebasetutorialjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.firebasetutorialjetpackcompose.navigation.NavigationGraph
import com.example.firebasetutorialjetpackcompose.ui.theme.FirebaseTutorialJetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirebaseTutorialJetpackComposeTheme {
                val navController = rememberNavController()
                NavigationGraph(navController = navController)
            }
        }
    }
}