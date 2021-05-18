package com.bignerdranch.android.redo.data

import androidx.lifecycle.LiveData

class TimeRepository(private val timeDao: TimeDao) {

    val readAllData: LiveData<List<Time>> = timeDao.readAllData()

    suspend fun addTime(time: Time){
        timeDao.addTime(time)
    }

}