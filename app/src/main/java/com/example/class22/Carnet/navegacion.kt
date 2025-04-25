package com.example.class22.Carnet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun MostrarNavegacion() {
        val navController = rememberNavController()
        val mascotaViewModel = remember { MascotaViewModel() }
        NavHost(navController, startDestination = "screenA") {
            composable(
                route = "screenA?editIndex={editIndex}",
                arguments = listOf(navArgument("editIndex") {
                    type = NavType.IntType
                    defaultValue = -1
                })
            ) { backStackEntry ->
                val index = backStackEntry.arguments?.getInt("editIndex")?.takeIf { it >= 0 }
                PantallaRegistro(navController, mascotaViewModel, indexEditar = index)
            }
            composable("screenB") {
                PantallaCarnet(navController, mascotaViewModel)
            }
        }
    }
