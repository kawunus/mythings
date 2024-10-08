package com.kawunus.mythings.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "places",
)
data class Place(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    @ColumnInfo("count_of_elements") val countOfElements: Int = 0,
    val image: ByteArray,
    //  val things: List<Thing>
)
