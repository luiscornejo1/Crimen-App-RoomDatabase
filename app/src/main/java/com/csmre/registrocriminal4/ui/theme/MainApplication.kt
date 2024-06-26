package com.csmre.registrocriminal4.ui.theme

import android.app.Application
import androidx.room.Room
import com.csmre.registrocriminal4.db.CrimenDatabase


class MainApplication : Application() {
    companion object {
        lateinit var crimenDatabase: CrimenDatabase
    }

    override fun onCreate() {
        super.onCreate()
        crimenDatabase = Room.databaseBuilder(
            applicationContext,
            CrimenDatabase::class.java,
            CrimenDatabase.NAME
        ).build()
    }
}
