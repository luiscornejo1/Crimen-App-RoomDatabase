package com.csmre.registrocriminal4.ui.theme

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Date

@Composable
fun AddCrimenScreen(crimenViewModel: CrimenViewModel, pickContactLauncher: ActivityResultLauncher<Void?>) {
    var id by remember { mutableStateOf("") }
    var titulo by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false)}
    
    val pickContactLauncher = rememberLauncherForActivityResult(ActivityResultContracts.PickContact()) {uri: Uri? -> uri?.let {
        showDialog = true
    }  }

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
        Spacer(modifier = Modifier.height(8.dp))
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
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { pickContactLauncher.launch(null) }) {
            Text("Elegir sospechoso", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { showDialog = true  }) {
            Text("Enviar reporte de crimen", fontSize = 18.sp)
        }

        if (showDialog){
            AlertDialog(onDismissRequest = { showDialog = false },
                title = { Text("Confirmacion")},
                text = {Text("Reporte enviado correctamente.")},
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("OK" )

                    }
                }

                )
        }
    }
}