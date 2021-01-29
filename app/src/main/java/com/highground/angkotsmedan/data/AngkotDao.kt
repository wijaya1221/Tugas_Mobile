package com.highground.angkotsmedan.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.highground.angkotsmedan.model.Angkot

@Dao
interface AngkotDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAngkot(angkot: Angkot)

    @Update
    fun updateAngkot(angkot: Angkot)

    @Delete
    fun deleteAngkot(angkot: Angkot)

    @Query("DELETE FROM angkot_table")
    suspend fun deleteAllAngkots()

    @Query("SELECT * FROM angkot_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Angkot>>

}