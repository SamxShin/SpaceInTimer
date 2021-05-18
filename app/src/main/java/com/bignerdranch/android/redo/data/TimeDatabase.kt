package com.bignerdranch.android.redo.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Time::class], version = 1, exportSchema = false)
abstract class TimeDatabase: RoomDatabase() {

    abstract fun timeDao(): TimeDao

    companion object{
        @Volatile
        private var INSTANCE: TimeDatabase? = null

        fun getDatabase(Context):
    }

}