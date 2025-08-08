package com.supervital.navigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.supervital.navigationcompose.contacts.ContactsScreen
import com.supervital.navigationcompose.route.NavBarItems
import com.supervital.navigationcompose.route.NavRoutes
import com.supervital.navigationcompose.screens.about.AboutScreen
import com.supervital.navigationcompose.screens.home.HomeScreen
import com.supervital.navigationcompose.ui.theme.NavigationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreenWithNavigationAndList()
        }
    }
}

    @Composable
    fun MainScreenWithNavigationAndList() {
        var selectedIndex by remember { mutableIntStateOf(0) }
        val items = NavBarItems.BarItems // listOf("Home", "Settings") // For NavigationBar items
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
                        .padding(all = 8.dp)
                        .padding(innerPadding) // Apply padding from Scaffold
                ) {
                    when (selectedBarItem.route) {
                        NavRoutes.Home.route -> HomeScreen()
                        NavRoutes.Contacts.route -> ContactsScreen()
                        NavRoutes.About.route -> AboutScreen()
                    }
                }
            }
        }
    }

    @Composable
    fun HomeContent() {
        val dataItems = List(50) { "List Item $it" } // Example data for LazyColumn
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(dataItems) { item ->
                Text(text = item, modifier = Modifier.padding(16.dp))
            }
        }
    }

    @Composable
    fun SettingsContent() {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Settings Screen Content", modifier = Modifier.padding(16.dp))
            // Add more settings-related UI here
        }
    }

@Composable
fun Main() {
    // Контроллер навигации - управление стеком навигации
    val navController = rememberNavController()

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        NavHost(navController = navController,
            startDestination = NavRoutes.Home.route) {
            composable(NavRoutes.Home.route) { HomeScreen() }
            composable(NavRoutes.About.route) { AboutScreen() }
            composable(NavRoutes.Contacts.route) { ContactsScreen() }
        }

        BottomNavigationBar(navController = navController)
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavBarItems.BarItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {saveState = true}
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(imageVector = navItem.image,
                        contentDescription = navItem.title)
                },
                label = {
                    Text(text = navItem.title)
                }
            )
        }
    }
}