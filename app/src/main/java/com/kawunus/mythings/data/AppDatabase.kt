package com.kawunus.mythings.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kawunus.mythings.model.Place

@Database(entities = [Place::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun placeDao(): PlaceDao
}