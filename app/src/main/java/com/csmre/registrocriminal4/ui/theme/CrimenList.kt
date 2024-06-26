package com.csmre.registrocriminal4.ui.theme

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun CrimenList(crimenViewModel: CrimenViewModel) {
    val crimenes by crimenViewModel.crimenes.observeAsState(initial = emptyList())

    LazyColumn {
        items(crimenes) { crimen ->
            Text(text = crimen.toString())
            // Puedes agregar más elementos UI aquí para mostrar más detalles
        }
    }
}