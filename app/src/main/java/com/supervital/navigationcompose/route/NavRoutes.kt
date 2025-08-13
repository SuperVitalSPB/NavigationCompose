package com.supervital.navigationcompose.route

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Contacts : NavRoutes("contacts")
    object Weather : NavRoutes("weather")
    object About : NavRoutes("about")
}