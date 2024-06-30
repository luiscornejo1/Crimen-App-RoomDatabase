package com.csmre.registrocriminal4.ui.theme

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS), 1)
        }
        val pickContactLauncher = registerForActivityResult (ActivityResultContracts.PickContact()) {uri: Uri? ->

        }
        setContent {
            val crimenViewModel = viewModel<CrimenViewModel>()
            CrimenList(crimenViewModel)
            MaterialTheme {
                Surface {
                    MyNavigation(crimenViewModel,pickContactLauncher)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyNavigation(crimenViewModel: CrimenViewModel, pickContactLauncher: ActivityResultLauncher<Void?>) {
    val navController = rememberNavController()
    val crimenViewModel: CrimenViewModel = viewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Registro de Crímenes") },
                actions = {
                    IconButton(onClick = { navController.navigate("addCrimenRoute")
                        // Define aquí la acción para añadir un nuevo crimen
                    }) {
                        Icon(Icons.Filled.Add, contentDescription = "Agregar Crimen")
                    }
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "listaCrimenesFragment",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("listaCrimenesFragment") {
                ListaCrimenesFragment(navController, crimenViewModel)
            }
            composable("crimenFragment") {
                CrimenFragment(navController)
            }
            composable("addCrimenRoute"){
                AddCrimenScreen(crimenViewModel, pickContactLauncher)
            }
        }
    }
}
