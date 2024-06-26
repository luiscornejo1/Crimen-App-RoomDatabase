package com.csmre.registrocriminal4.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.csmre.registrocriminal4.ui.theme.Crimen

@Dao
interface CrimenDao {

    @Query("SELECT * FROM crimen ORDER BY createdAt DESC")
    fun getAllCrimen() : LiveData<List<Crimen>>

    @Query("SELECT * FROM crimen WHERE id = :id")
    fun getCrimenById(id: String): LiveData<Crimen>

    @Query("SELECT EXISTS(SELECT 1 FROM Crimen WHERE id = :id)")
    fun exists(id: Int): Boolean

    @Insert
    suspend fun addCrimen(crimen: Crimen)

    @Delete
    suspend fun deleteCrimen(crimen:Crimen)



}