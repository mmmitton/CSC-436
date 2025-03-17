package com.zybooks.snackulator.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.zybooks.snackulator.data.Beverage
import com.zybooks.snackulator.data.BeverageDataSource

@Composable
fun SnackApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("starbucks") { StarbucksScreen(navController) }
        composable("hot_coffee") { HotCoffeeScreen(navController) }

        // Accept the beverage name as a parameter in the route.
        composable("bevmodscreen/{beverageName}") { backStackEntry ->
            val beverageName = backStackEntry.arguments?.getString("beverageName")
            val beverage = when (beverageName) {
                "Caffe Latte" -> BeverageDataSource().Caffe_Latte
                //"Americano" -> BeverageDataSource().Americano
                else -> null
            }
            // Use the view model wrapper to handle state updates.
            beverage?.let {
                BeverageModScreenViewModel(initialBeverage = it)
            }
        }
    }
}

