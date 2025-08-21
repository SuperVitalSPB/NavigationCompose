package com.supervital.navigationcompose.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.supervital.feature.route.NavBarItems
import com.supervital.feature.route.NavRoutes
import com.supervital.feature.screens.about.AboutScreen
import com.supervital.feature.screens.weather.WeatherScreen
import com.supervital.feature.screens.contacts.ContactsScreen
import com.supervital.feature.screens.home.HomeScreen
import com.supervital.navigationcompose.theme.NavigationComposeTheme

@Composable
fun MainScreenWithNavigationAndListScreen() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val items = NavBarItems.BarItems
    val selectedBarItem = NavBarItems.BarItems[selectedIndex]
    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                item.image,
                                contentDescription = item.title
                            )
                        },
                        label = { Text(item.title) },
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavigationComposeTheme {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 5.dp)
                    .padding(innerPadding) // Apply padding from Scaffold
            ) {
                when (selectedBarItem.route) {
                    NavRoutes.Home.route -> HomeScreen()
                    NavRoutes.Contacts.route -> ContactsScreen()
                    NavRoutes.Weather.route -> WeatherScreen()
                    NavRoutes.About.route -> AboutScreen()
                }
            }
        }
    }
}