package com.example.class22.Carnet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import coil.compose.AsyncImage
@Composable
fun PantallaCarnet(navController: NavController, viewModel: MascotaViewModel) {
    val VerdeMenta = Color(0xFFA8E6CF)
    val AzulCeleste = Color(0xFFDCEEF2)
    val BeigeClaro = Color(0xFFFFF9E6)
    val TextoGris = Color(0xFF4A6D7C)
    val VerdeOscuro = Color(0xFF388E3C)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BeigeClaro)
    ) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(BeigeClaro),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                "Mascotas Registradas",
                style = MaterialTheme.typography.headlineSmall,
                color = VerdeOscuro
            )
        }

        viewModel.listaMascotas.forEachIndexed { index, mascota ->
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(6.dp),
                    colors = CardDefaults.cardColors(containerColor = AzulCeleste)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        AsyncImage(
                            model = mascota.fotoUrl,
                            contentDescription = "Foto de la mascota",
                            modifier = Modifier
                                .size(88.dp)
                                .clip(CircleShape)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            "${mascota.nombre} - ${mascota.raza}",
                            style = MaterialTheme.typography.titleMedium,
                            color = TextoGris
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Tamaño: ${mascota.tamano}", color = TextoGris)
                            Text("Edad: ${mascota.edad} años", color = TextoGris)
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Button(onClick = {
                                viewModel.eliminarMascota(index)
                            }) {
                                Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                            }

                            Button(onClick = {
                                navController.navigate("screenA?editIndex=$index")
                            }) {
                                Icon(Icons.Default.Edit, contentDescription = "Editar")
                            }
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { navController.navigate("screenA") },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = VerdeMenta)
            ) {
                Text(" + Registrar nueva mascota", color = TextoGris)
            }
        }
    }
}
}



