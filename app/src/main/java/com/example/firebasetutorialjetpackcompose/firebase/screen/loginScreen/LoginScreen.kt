package com.example.firebasetutorialjetpackcompose.firebase.screen.loginScreen

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import com.example.firebasetutorialjetpackcompose.firebase.auth.Constant.ServerClient
import com.example.firebasetutorialjetpackcompose.firebase.screen.ButtonComponent
import com.example.firebasetutorialjetpackcompose.firebase.screen.EmailTextField
import com.example.firebasetutorialjetpackcompose.firebase.screen.GoogleButton
import com.example.firebasetutorialjetpackcompose.firebase.screen.PasswordMyTextField
import com.example.firebasetutorialjetpackcompose.firebase.screen.TextComponent
import com.example.firebasetutorialjetpackcompose.navigation.Screen
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthCredential
import com.google.firebase.auth.GoogleAuthProvider
import kotlin.math.log

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel : LoginViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val loginState by loginViewModel.loginState.collectAsState(initial = LoginState())
    val googleState = loginViewModel.googleSignInState.value
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {

        val account  = GoogleSignIn.getSignedInAccountFromIntent(it.data)
        try {
            val result = account.getResult(ApiException::class.java)
            val credentials = GoogleAuthProvider.getCredential(result.idToken,null)
            loginViewModel.signInWithGoogle(credentials)
        }catch (e:ApiException){
           println(e)
        }
    }
    LaunchedEffect(key1 = googleState) {
        if (googleState.isSuccess != null){
            Toast.makeText(context, "Sign in success", Toast.LENGTH_SHORT).show()
        }
        if (googleState.isFailure != null){
            Toast.makeText(context,"Error",Toast.LENGTH_SHORT).show()
        }
    }



    LaunchedEffect(key1 = loginState) {
        if(loginState.isSuccess != null){
            Toast.makeText(context, loginState.isSuccess, Toast.LENGTH_SHORT).show()
        }
        if (loginState.isError != "") {
            Toast.makeText(context, loginState.isError, Toast.LENGTH_SHORT).show()
        }
    }

    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }


    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            TextComponent(text = stringResource(id = R.string.login_title))
            EmailTextField(labelValue = stringResource(id = R.string.email), imageVector = Icons.Outlined.Email, onValueChange = {email = it})
            PasswordMyTextField(labelValue = stringResource(id = R.string.password), imageVector = Icons.Outlined.Password, onValueChange = {password = it})
            ButtonComponent(value = stringResource(id = R.string.login), onClick = {
                loginViewModel.loginUser(email,password)
            })
            GoogleButton(
                onClick = {
                    val gso =  GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail()
                        .requestIdToken(ServerClient)
                        .build()

                    val googleSignInClient = GoogleSignIn.getClient(context,gso)
                    launcher.launch(googleSignInClient.signInIntent)
                    navController.navigate(Screen.LoginCreateAccountScreen.route)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPrew(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}