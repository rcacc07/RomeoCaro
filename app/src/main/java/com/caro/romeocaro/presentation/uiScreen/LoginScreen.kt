package com.caro.romeocaro.presentation.uiScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.caro.romeocaro.R



@Composable
fun LoginScreen(navController : NavHostController){

    val modifier = Modifier

    var user by remember { mutableStateOf("") }
    var isValidUser by remember { mutableStateOf(false) }

    var password by remember { mutableStateOf("") }
    var isValidPassword by remember { mutableStateOf(false) }


    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(painter = painterResource(id = R.drawable.login) , contentDescription = "image login")
        Text(
            text = "Welcome Movies App",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = user,
            onValueChange = {
                user = it
                isValidUser = user.equals("user") },
            maxLines = 1,
            singleLine = true,
            label = {
                Text(text = "User")
            }

        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            singleLine = true,
            maxLines = 1,
            onValueChange = {
                password = it
                isValidPassword = password.equals("Password*123")},
            label = {
                Text(text = "Password")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(16.dp))

        val linearGradientBrush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFB226E1),
                Color(0xFFFC6603),
                Color(0xFF5995EE),
                Color(0xFF3D3535)
            ),
            start = Offset(Float.POSITIVE_INFINITY, 0f),
            end = Offset(0f, Float.POSITIVE_INFINITY),
        )

        Button(
            onClick = { login (navController,isValidUser,isValidPassword) },

            modifier
                .background(color = Color.Gray.copy(0.8f), RoundedCornerShape(16.dp))
                .border(
                    BorderStroke(
                        3.dp,
                        linearGradientBrush
                    ),
                    shape = RoundedCornerShape(16.dp)
                ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Text(text = "continuar" ,style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.cinzel_decorative)),
                textAlign = TextAlign.Center
            )
            )
        }
    }

}

fun login(navController : NavHostController,
          isValidUser : Boolean, isValidPassword : Boolean) {
    if (isValidUser && isValidPassword){
        navController.navigate("Home Screen")
    }
}

