package com.supervital.navigationcompose.route

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = NavRoutes.Home.route
        ),
        BarItem(
            title = "Contacts",
            image = Icons.Filled.Face,
            route = NavRoutes.Contacts.route
        ),
        BarItem(
            title = "About",
            image = Icons.Filled.Info,
            route = NavRoutes.About.route
        )
    )
}