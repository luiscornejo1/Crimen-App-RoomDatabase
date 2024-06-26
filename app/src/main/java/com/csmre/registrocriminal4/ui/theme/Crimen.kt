package com.csmre.registrocriminal4.ui.theme

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Crimen(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var titulo: String,
    var createdAt: Date



)
