package com.example.class22.Carnet

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

data class Mascota(
    val nombre: String,
    val raza: String,
    val tamano: String,
    val edad: String,
    val fotoUrl: String
)

class MascotaViewModel {
    val listaMascotas: SnapshotStateList<Mascota> = mutableStateListOf()

    fun agregarMascota(mascota: Mascota) {
        listaMascotas.add(mascota)
    }

    fun eliminarMascota(index: Int) {
        if (index in listaMascotas.indices) {
            listaMascotas.removeAt(index)
        }
    }

    fun editarMascota(index: Int, nueva: Mascota) {
        if (index in listaMascotas.indices) {
            listaMascotas[index] = nueva
        }
    }
}