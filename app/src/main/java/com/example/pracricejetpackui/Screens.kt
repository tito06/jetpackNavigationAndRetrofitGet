package com.example.pracricejetpackui

sealed class Screens(val route: String) {

    object Login:Screens("login_screens")
    object Dashboard: Screens("dashboard_screen" + "/{username_key}")

}