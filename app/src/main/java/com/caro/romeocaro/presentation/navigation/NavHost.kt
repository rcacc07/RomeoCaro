package com.caro.romeocaro.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.caro.romeocaro.presentation.uiScreen.DetailsScreen
import com.caro.romeocaro.presentation.uiScreen.HomeScreen
import com.caro.romeocaro.presentation.uiScreen.LoginScreen

@Composable
fun Navigation(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login screen") {
        composable("Login screen") {
            LoginScreen(navController = navController)
        }
        composable("Home screen") {
            HomeScreen(navController = navController)
        }
        composable("Details screen/{id}",
            arguments = listOf(
                navArgument(
                    name = "id"
                ) {
                    type = NavType.IntType
                }
            )
        ) {id->
            id.arguments?.getInt("id")?.let { id1->
                DetailsScreen(id =id1)
            }

        }
    }

}