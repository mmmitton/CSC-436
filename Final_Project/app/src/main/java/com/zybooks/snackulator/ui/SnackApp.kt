package com.zybooks.snackulator.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun SnackApp(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home")
    {
        composable("home"){ HomeScreen(navController) }
        composable("starbucks"){ StarbucksScreen(navController) }
        composable("hot_coffee"){ HotCoffeeScreen() }

    }
}