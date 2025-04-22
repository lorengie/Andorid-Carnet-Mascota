package com.example.class22.Carnet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

@Composable
fun PantallaCarnet(nombre: String, raza: String, tamano: String, edad: String, fotoUrl: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = rememberImagePainter(fotoUrl),
                contentDescription = "Foto de la mascota",
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("Carnet de Mascota", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Nombre: $nombre")
            Text("Raza: $raza")
            Text("Tamaño: $tamano")
            Text("Edad: $edad años")
        }
    }
}
