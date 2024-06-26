package com.csmre.registrocriminal4.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun ListaCrimenesFragment(navController: NavController, CrimenViewModel: CrimenViewModel) {
    val crimenes by CrimenViewModel.crimenes.observeAsState(initial = emptyList())

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(crimenes) { crimen ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = crimen.titulo,
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            // Suponiendo que tienes un detalle de crimen fragment para ver más detalles
                            navController.navigate("CrimenFragment/${crimen.id}")
                        },
                    color = Color.Black
                )
                IconButton(onClick = {
                    CrimenViewModel.deleteCrimen(crimen)
                }) {
                    Icon(Icons.Default.Delete, contentDescription = "Eliminar Crimen")
                }
            }
        }
    }
}