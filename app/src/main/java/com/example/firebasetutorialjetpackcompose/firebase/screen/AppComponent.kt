package com.example.firebasetutorialjetpackcompose.firebase.screen


import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebasetutorialjetpackcompose.ui.theme.BgColor
import com.example.firebasetutorialjetpackcompose.ui.theme.Primary
import com.example.firebasetutorialjetpackcompose.ui.theme.TextColor
import com.example.firebasetutorialjetpackcompose.R

@Composable
fun TextComponent(
    text: String
) {

    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )

}

@Composable
fun HeaderTextComponent(text: String) {

    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = Color.Black,
        textAlign = TextAlign.Center
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldFirstNameAndLastName(labelValue: String, imageVector: ImageVector) {

    var textValueName by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        value = textValueName,
        onValueChange = {
            textValueName = it
        },
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            containerColor = BgColor
        ),
        keyboardOptions = KeyboardOptions.Default,
        leadingIcon = {
            Icon(imageVector = imageVector, contentDescription = "")
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField(
    labelValue: String,
    imageVector: ImageVector,
    onValueChange: (String) -> Unit
) {
    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            onValueChange(it)
        },
        label = { Text(text = labelValue) },
        leadingIcon = {
            Icon(imageVector = imageVector, contentDescription = "")
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordMyTextField(labelValue: String, imageVector: ImageVector, onValueChange: (String) -> Unit) {
    var passwordValue by rememberSaveable {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = passwordValue,
        onValueChange = {
            passwordValue = it
            onValueChange(it)
        },
        label = { Text(text = labelValue) },
        leadingIcon = {
            Icon(imageVector = imageVector, contentDescription = "")
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            val description = if (passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            focusedLabelColor = Color.Blue,
            cursorColor = Color.Blue,
            containerColor = Color.White
        )
    )
}

@Composable
fun CheckboxComponent(value: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        var checkedState by remember {
            mutableStateOf(false)
        }
        Checkbox(
            checked = checkedState,
            onCheckedChange = {
                checkedState = !checkedState
            })

        ClickableTextComponent(value = value)
    }
}

@Composable
fun ClickableTextComponent(value: String) {
    val initialText = "By continuing you accept our"
    val privacyPolicyText = "Privacy Policy"
    val andText = "and"
    val termsOfUseConditions = "Term of Use"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Primary)) {
            pushStringAnnotation(tag = termsOfUseConditions, annotation = termsOfUseConditions)
            append(termsOfUseConditions)
        }
    }
    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull().also { span ->
                Log.d("ClickableTextComponent", "${span!!.item}")
            }
    })

}

@Composable
fun ButtonComponent(
    value: String,
    onClick : () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Primary
        ),
        onClick = {
            onClick()
        }) {
        Text(
            text = value,
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.White
            )
        )
    }
}

@Composable
fun DividerTextComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(2.dp),
            color = Color.Gray,
            thickness = 1.dp
        )
        Text(text = stringResource(id = R.string.or), fontSize = 18.sp)
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(2.dp),
            color = Color.Gray,
            thickness = 1.dp
        )

    }
}

@Composable
fun GoogleButton(onClick: () -> Unit) {
    Button(
        onClick = onClick
    ) {
        Icon(painter = painterResource(id = R.drawable.google), contentDescription = "",modifier = Modifier.size(50.dp))
    }
}