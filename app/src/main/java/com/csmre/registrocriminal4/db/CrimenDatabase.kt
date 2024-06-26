package com.csmre.registrocriminal4.db

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.csmre.registrocriminal4.ui.theme.Crimen

@Database(
    entities = [Crimen::class],
    version = 4,
    autoMigrations = [
        AutoMigration (from = 3 , 4)
    ] )

@TypeConverters(Converters::class)
abstract class CrimenDatabase : RoomDatabase() {
    abstract fun CrimenDao(): CrimenDao

    companion object {
        @Volatile
        private var INSTANCE: CrimenDatabase? = null
        const val NAME = "Crimendatabase.db"

        fun getDatabase(context: Context): CrimenDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CrimenDatabase::class.java,
                    NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}