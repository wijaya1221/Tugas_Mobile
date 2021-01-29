package com.highground.angkotsmedan.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.highground.angkotsmedan.model.Angkot

@Database(entities = [Angkot::class], version = 1, exportSchema = false)
abstract class AngkotDatabase: RoomDatabase() {

    abstract fun angkotDao(): AngkotDao

    companion object{
        @Volatile
        private var INSTANCE: AngkotDatabase? = null

        fun getDatabase(context: Context): AngkotDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AngkotDatabase::class.java,
                        "angkot_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }
}