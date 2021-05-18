package com.bignerdranch.android.redo.data

import androidx.room.Database
import java.util.*
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "time_table")

data class Time(
    @PrimaryKey
    val id: Int,
    val comleteTime: Int,
    val totalTime: Int,
    val date: String,
)
