package com.example.class22.Carnet
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.*
class Navegacion {
    @Composable
    fun MostrarNavegacion() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "screenA") {
            composable("screenA") { PantallaRegistro(navController) }
            composable(
                "screenB/{nombre}/{raza}/{tamano}/{edad}/{fotoUrl}"
            ) { backStackEntry ->
                val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
                val raza = backStackEntry.arguments?.getString("raza") ?: ""
                val tamano = backStackEntry.arguments?.getString("tamano") ?: ""
                val edad = backStackEntry.arguments?.getString("edad") ?: ""
                val fotoUrl = backStackEntry.arguments?.getString("fotoUrl") ?: ""
                PantallaCarnet(nombre, raza, tamano, edad, fotoUrl)
            }
        }
    }
}
