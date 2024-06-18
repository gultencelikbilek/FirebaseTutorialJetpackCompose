package com.example.firebasetutorialjetpackcompose.firebase.screen.first_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.firebasetutorialjetpackcompose.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardComponent(navController: NavController,text : String) {

        Card(
            onClick = {
                if(Screen.CreateAccountScreen.route == "create_account_screen"){
                    navController.navigate(Screen.CreateAccountScreen.route)
                }else{
                    navController.navigate(Screen.LoginScreen.route)
                }
            },
            shape = RoundedCornerShape(15.dp),
            content = {
                Text(
                    text = text,
                style = TextStyle(
                fontSize = MaterialTheme.typography.displayMedium.fontSize,
                    color = Color.Black
            ),
                    textAlign = TextAlign.Center

                ) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .width(90.dp)
                .height(60.dp)
        )

}

@Preview(showBackground = true)
@Composable
fun Prev(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    CardComponent(navController = navController,"Login")
}