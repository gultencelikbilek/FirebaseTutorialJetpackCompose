package com.example.firebasetutorialjetpackcompose.firebase.screen.createScreen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.firebasetutorialjetpackcompose.R
import com.example.firebasetutorialjetpackcompose.firebase.screen.ButtonComponent
import com.example.firebasetutorialjetpackcompose.firebase.screen.CheckboxComponent
import com.example.firebasetutorialjetpackcompose.firebase.screen.DividerTextComponent
import com.example.firebasetutorialjetpackcompose.firebase.screen.HeaderTextComponent
import com.example.firebasetutorialjetpackcompose.firebase.screen.EmailTextField
import com.example.firebasetutorialjetpackcompose.firebase.screen.GoogleButton
import com.example.firebasetutorialjetpackcompose.firebase.screen.MyTextFieldFirstNameAndLastName
import com.example.firebasetutorialjetpackcompose.firebase.screen.PasswordMyTextField
import com.example.firebasetutorialjetpackcompose.firebase.screen.TextComponent
import com.example.firebasetutorialjetpackcompose.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CreateAccountScreen(
    navController: NavController,
    viewModel: CreateScreenViewModel = hiltViewModel()
) {
    val scope = rememberCoroutineScope()
    var email by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }
    val context = LocalContext.current
    val state by viewModel.cretaeState.collectAsState(initial = CreateState())//viewmodel.createState içindeki durumlar iszlenir


    LaunchedEffect(state) { //state içindeki durumlara göre işlemler yapılır
        if (state.isSuccess != "") {
            Toast.makeText(context, state.isSuccess, Toast.LENGTH_SHORT).show()
        }
        if (state.isError != "") {
            Toast.makeText(context, state.isError, Toast.LENGTH_SHORT).show()
        }
    }

    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TextComponent(text = stringResource(id = R.string.hey_there))
            HeaderTextComponent(text = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(20.dp))
            MyTextFieldFirstNameAndLastName(labelValue = stringResource(id = R.string.first_name), imageVector = Icons.Outlined.Person)
            MyTextFieldFirstNameAndLastName(labelValue = stringResource(id = R.string.last_name), imageVector = Icons.Outlined.Person)
            EmailTextField(labelValue = stringResource(id = R.string.email), imageVector = Icons.Outlined.Email, onValueChange = { email = it })
            PasswordMyTextField(labelValue = stringResource(id = R.string.password), imageVector = Icons.Outlined.Lock, onValueChange = { password = it })
            CheckboxComponent(value = stringResource(id = R.string.terms_of_condition))
            ButtonComponent(value = "Register", onClick = {
                viewModel.createUser(email, password)
                navController.navigate(Screen.LoginCreateAccountScreen.route)
            })
            DividerTextComponent()


        }
    }
}

@Preview(showBackground = true)
@Composable
fun x(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    CreateAccountScreen(navController =navController )
}