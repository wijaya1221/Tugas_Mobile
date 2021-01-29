package com.highground.angkotsmedan.repository

import androidx.lifecycle.LiveData
import com.highground.angkotsmedan.data.AngkotDao
import com.highground.angkotsmedan.model.Angkot

class AngkotRepository(private val angkotDao: AngkotDao) {

    val readAllData: LiveData<List<Angkot>> = angkotDao.readAllData()

    suspend fun addAngkot(angkot: Angkot){
        angkotDao.addAngkot(angkot)
    }

    suspend fun updateAngkot(angkot: Angkot){
        angkotDao.updateAngkot(angkot)
    }

    suspend fun deleteAngkot(angkot: Angkot){
        angkotDao.deleteAngkot(angkot)
    }

    suspend fun deleteAllAngkots(){
        angkotDao.deleteAllAngkots()
    }
}