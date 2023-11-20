package com.example.pracricejetpackui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pracricejetpackui.ui.theme.PracriceJetpackUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracriceJetpackUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .height(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {


                        val navController = rememberNavController()
                        NavGraph(navController = navController)
                       /* Text(text = "Login",
                            fontSize = 20.sp)*/

                        //Login()

                    }


                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController){

    var userName by remember {
        mutableStateOf("")
    }
    
    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {





        OutlinedTextField(
            value = userName,
            onValueChange = {text ->
                            userName = text
            },
        label = { Text(text = "USER NAME")})


        OutlinedTextField(
            value = password,
            onValueChange ={
                password = it
            },
        label = { Text(text = "Password")},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                var image =if (passwordVisible)
                    Icons.Outlined.Lock
                else Icons.Outlined.Add
                
                IconButton(onClick = { passwordVisible = !passwordVisible })
                {
                    Icon(imageVector = image, contentDescription ="" )
                }
            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { navController.navigate(route = "dashboard_screen" + "/$userName") },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Magenta
        )) {

            Text(text = "LOGIN")
            
        }

    }

}

