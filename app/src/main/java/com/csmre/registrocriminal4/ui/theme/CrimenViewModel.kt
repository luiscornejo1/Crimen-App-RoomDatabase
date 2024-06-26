package com.csmre.registrocriminal4.ui.theme

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.csmre.registrocriminal4.db.CrimenDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CrimenViewModel(application: Application) : AndroidViewModel(application) {
    private val crimenDao = CrimenDatabase.getDatabase(application).CrimenDao()

    val crimenes: LiveData<List<Crimen>> = crimenDao.getAllCrimen()

    fun addCrimen(crimen: Crimen) = viewModelScope.launch(Dispatchers.IO) {
        val exists = crimenDao.exists(crimen.id)
        if (!exists) {
            try {
                crimenDao.addCrimen(crimen)
            } catch (e: Exception) {
                Log.e("AddCrimen", "Error adding crime", e)
            }
        }
    }
    fun deleteCrimen(crimen: Crimen) = viewModelScope.launch(Dispatchers.IO) {
        try {
            crimenDao.deleteCrimen(crimen)
        } catch (e:Exception){
            Log.e("DeleteCrimen","Error deleting crimen", e)
        }
    }
}