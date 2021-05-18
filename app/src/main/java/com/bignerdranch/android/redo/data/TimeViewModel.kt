package com.bignerdranch.android.redo.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TimeViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Time>>
    private val repository: TimeRepository
    init {
        val timeDao = TimeDatabase.getDatabase(application).TimeDao()
        repository = TimeRepository(timeDao)
        readAllData = repository.readAllData
    }
    fun addTime(time: Time){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTime(time)
        }
    }
}