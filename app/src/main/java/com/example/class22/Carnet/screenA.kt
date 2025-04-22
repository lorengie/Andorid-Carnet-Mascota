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
import androidx.compose.material.OutlinedTextField

@Composable
fun PantallaRegistro(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var raza by remember { mutableStateOf("") }
    var tamano by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var fotoUrl by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Nombre") })
        OutlinedTextField(value = raza, onValueChange = { raza = it }, label = { Text("Raza") })
        OutlinedTextField(value = tamano, onValueChange = { tamano = it }, label = { Text("Tamaño") })
        OutlinedTextField(value = edad, onValueChange = { edad = it }, label = { Text("Edad") })
        OutlinedTextField(value = fotoUrl, onValueChange = { fotoUrl = it }, label = { Text("URL de la foto")
        })
        Button(
            onClick = {
                navController.navigate("screenB/$nombre/$raza/$tamano/$edad/$fotoUrl")
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Registrar")
        }
    }
}



