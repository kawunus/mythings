package com.kawunus.mythings

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlaceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(place: Place)

    @Query("SELECT * FROM places")
    fun getAllPlaces(): LiveData<List<Place>>

    @Delete
    suspend fun delete(place: Place)
}