package com.csmre.registrocriminal4.ui.theme

import android.app.DatePickerDialog
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import java.util.Calendar

@Composable
fun CrimenFragment(navController: NavHostController) {
    var titulo by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("")}
    val context = LocalContext.current

    BackHandler(enabled = true) {
        if (titulo.isEmpty()) {
            Toast.makeText(context, "El título no puede estar vacío.", Toast.LENGTH_LONG).show()
        } else {
            navController.popBackStack()
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Título")
        TextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Ingrese un título para el crimen") }
        )


        Button(
            onClick = {
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)

                DatePickerDialog(context, { _, selectedYear, selectedMonth, selectedDay ->
                    fecha = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                }, year, month, day).show()
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Seleccionar Fecha")
        }

        if (fecha.isNotEmpty()) {
            Text(text = "Fecha seleccionada: $fecha", modifier = Modifier.padding(top = 16.dp))
        }

        Button(
            onClick = {
                val timePickerFragment = FragmentoTimePicker { _, selectedHour, selectedMinute ->
                    hora = "$selectedHour:$selectedMinute"
                }
                val fragmentActivity = context as? FragmentActivity
                if (fragmentActivity != null){
                    timePickerFragment.show(fragmentActivity.supportFragmentManager, "timePicker")
                } else {
                    Toast.makeText(context, "Error al mostrar el TimePicker", Toast.LENGTH_LONG).show()
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Seleccionar Hora")
        }

        if (hora.isNotEmpty()) {
            Text(text = "Hora seleccionada: $hora", modifier = Modifier.padding(top = 16.dp))
        }




    }
}
