package com.kawunus.mythings

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "places")
data class Place(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    @ColumnInfo("count_of_elements") val countOfElements: Int,
    // val image: String,
    // val things: List<Thing>
)