package com.highground.angkotsmedan.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@kotlinx.parcelize.Parcelize
@Entity(tableName = "angkot_table")
data class Angkot (
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val nomorAngkot: String,
        val ruteAngkot: String,
        val warnaAngkot: String,
): Parcelable
