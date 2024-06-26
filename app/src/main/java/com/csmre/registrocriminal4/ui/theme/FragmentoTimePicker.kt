package com.csmre.registrocriminal4.ui.theme

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class FragmentoTimePicker(private val listener: TimePickerDialog.OnTimeSetListener) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        return TimePickerDialog(requireContext(), listener, hour, minute, true)
    }
}