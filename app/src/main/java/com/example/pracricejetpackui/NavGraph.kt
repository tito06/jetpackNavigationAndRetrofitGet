package com.example.pracricejetpackui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun NavGraph(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = Screens.Login.route ){


        composable(route = Screens.Login.route){
            Login(navController)
        }

        composable(route = Screens.Dashboard.route,
        arguments = listOf(
            navArgument(name = "username_key"){
                type= NavType.StringType
            }
        )
        ){
            val name = it.arguments?.getString("username_key")
            Dashboard(userName = name!!)
        }
    }

}