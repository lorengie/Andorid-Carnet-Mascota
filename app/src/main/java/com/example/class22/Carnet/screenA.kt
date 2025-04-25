package com.example.class22.Carnet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment

@Composable
fun PantallaRegistro(navController: NavController, viewModel: MascotaViewModel, indexEditar: Int? = null) {
    val mascotaAEditar = indexEditar?.let { viewModel.listaMascotas[it] }
    var nombre by remember { mutableStateOf(mascotaAEditar?.nombre ?: "") }
    var raza by remember { mutableStateOf(mascotaAEditar?.raza ?: "") }
    var tamano by remember { mutableStateOf(mascotaAEditar?.tamano ?: "") }
    var edad by remember { mutableStateOf(mascotaAEditar?.edad ?: "") }
    var fotoUrl by remember { mutableStateOf(mascotaAEditar?.fotoUrl ?: "") }
    var error by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    val VerdeMenta = Color(0xFFA8E6CF)
    val AzulCeleste = Color(0xFFDCEEF2)
    val BeigeClaro = Color(0xFFFFF9E6)
    val TextoGris = Color(0xFF4A6D7C)
    val VerdeOscuro = Color(0xFF388E3C)
    val RojoCoral = Color(0xFFFF6F61)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BeigeClaro)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = if (indexEditar != null) " Editar Mascota" else " Registro de Mascota",
                style = MaterialTheme.typography.headlineMedium,
                color = VerdeOscuro
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (error.isNotEmpty()) {
                Text(
                    text = error,
                    color = RojoCoral,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre", color = TextoGris) },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AzulCeleste, shape = RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = raza,
                onValueChange = { raza = it },
                label = { Text("Raza", color = TextoGris) },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AzulCeleste, shape = RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = tamano,
                onValueChange = { tamano = it },
                label = { Text("Tamaño", color = TextoGris) },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AzulCeleste, shape = RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = edad,
                onValueChange = { edad = it },
                label = { Text("Edad", color = TextoGris) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AzulCeleste, shape = RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = fotoUrl,
                onValueChange = { fotoUrl = it },
                label = { Text("URL de la foto", color = TextoGris) },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AzulCeleste, shape = RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (nombre.isBlank() || fotoUrl.isBlank()) {
                        error = "Nombre y URL son obligatorios"
                    } else {
                        val nueva = Mascota(nombre, raza, tamano, edad, fotoUrl)
                        if (indexEditar != null) {
                            viewModel.editarMascota(indexEditar, nueva)
                        } else {
                            viewModel.agregarMascota(nueva)
                        }
                        navController.navigate("screenB") {
                            popUpTo("screenA") { inclusive = true }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = VerdeOscuro,
                    contentColor = Color.White
                )
            ) {
                Text(if (indexEditar != null) "💾 Guardar Cambios" else "✅ Registrar Mascota")
            }
        }
    }
}





