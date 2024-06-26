package com.csmre.registrocriminal4.ui.theme

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaCrimenesScreen(navController: NavController) {
    // Observar la lista de crímenes desde el ViewModel
    val crimenViewModel : CrimenViewModel = viewModel()
    }







