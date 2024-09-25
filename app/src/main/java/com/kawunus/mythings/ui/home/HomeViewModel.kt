package com.kawunus.mythings.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kawunus.mythings.ui.adapter.places.PlacesAdapter
import com.kawunus.mythings.data.AppDatabase
import com.kawunus.mythings.model.Place

class HomeViewModel(private val database: AppDatabase) : ViewModel() {

    val allPlaces: LiveData<List<Place>> = database.placeDao().getAllPlaces()

    fun loadPlaces(adapter: PlacesAdapter) {
        allPlaces.observeForever { places ->
            adapter.saveData(places)
        }
    }

}