package com.bignerdranch.android.redo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Time::class], version = 1, exportSchema = false)
abstract class TimeDatabase: RoomDatabase() {

    abstract fun TimeDao(): TimeDao

    companion object {
        @Volatile
        private var INSTANCE: TimeDatabase? = null

        fun getDatabase(context: Context): TimeDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TimeDatabase::class.java,
                    "time_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}