package com.csmre.registrocriminal4.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import java.util.Date

@Composable
fun AddCrimenScreen(crimenViewModel: CrimenViewModel) {
    var id by remember { mutableStateOf("") }
    var titulo by remember { mutableStateOf("") }

    Column {
        TextField(
            value = id,
            onValueChange = { id = it },
            label = { Text("ID del crimen") }
        )
        TextField(
            value = titulo,
            onValueChange = { titulo= it },
            label = { Text("TITULO del crimen xd") }
        )
        Button(onClick = {
            if (titulo.isNotBlank() && id.isNotBlank()){
                try {
                    val idInt = id.toInt()
                    val nuevoCrimen = Crimen(id=idInt,titulo=titulo, createdAt = Date())
                    crimenViewModel.addCrimen(nuevoCrimen)
                } catch (e: NumberFormatException){

                }
            }

        }) {
            Text("Añadir Crimen")
        }
    }
}