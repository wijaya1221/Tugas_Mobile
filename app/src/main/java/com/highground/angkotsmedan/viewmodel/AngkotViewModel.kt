package com.highground.angkotsmedan.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.highground.angkotsmedan.data.AngkotDatabase
import com.highground.angkotsmedan.repository.AngkotRepository
import com.highground.angkotsmedan.model.Angkot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AngkotViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Angkot>>
    private val repository: AngkotRepository

    init {
        val angkotDao = AngkotDatabase.getDatabase(application).angkotDao()
        repository = AngkotRepository(angkotDao)
        readAllData = repository.readAllData
    }

    fun addAngkot(angkot: Angkot){
        viewModelScope.launch (Dispatchers.IO){
            repository.addAngkot(angkot)
        }
    }

    fun updateAngkot(angkot: Angkot){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateAngkot(angkot)
        }
    }

    fun deleteAngkot(angkot: Angkot){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAngkot(angkot)
        }
    }

    fun deleteAllAngkots(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllAngkots()
        }
    }
}