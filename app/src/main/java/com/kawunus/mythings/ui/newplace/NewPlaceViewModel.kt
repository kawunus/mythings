package com.kawunus.mythings.ui.newplace

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawunus.mythings.data.AppDatabase
import com.kawunus.mythings.model.Place
import com.kawunus.mythings.util.ImageConverter
import kotlinx.coroutines.launch

class NewPlaceViewModel(private val database: AppDatabase) : ViewModel() {

    private var currentPlaces = emptyList<Place>()
    private val allPlaces: LiveData<List<Place>> = database.placeDao().getAllPlaces()

    init {
        loadPlaces()
    }

    private fun insertInDB(name: String, image: Bitmap) = viewModelScope.launch {
        database.placeDao()
            .insert(Place(name = name, image = ImageConverter.bitmapToByteArray(image)))
    }

    private fun loadPlaces() {
        allPlaces.observeForever { places ->
            currentPlaces = places
        }
    }

    private fun isExistInDB(name: String): Boolean {
        return currentPlaces.any { it.name == name }
    }


    fun insert(name: String, image: Bitmap): Int {
        return if (name.isEmpty()) {
            InsertCodes.EMPTY_NAME
        } else if (isExistInDB(name)) InsertCodes.EXIST
        else {
            insertInDB(name, image)
            InsertCodes.SUCCESSFUL
        }
    }

    object InsertCodes {
        const val SUCCESSFUL = 1
        const val EMPTY_NAME = 2
        const val EXIST = 3
    }
}