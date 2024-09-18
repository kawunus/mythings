package com.kawunus.mythings.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kawunus.mythings.ui.adapter.PlacesAdapter
import com.kawunus.mythings.R
import com.kawunus.mythings.data.AppDatabase
import com.kawunus.mythings.model.Place
import kotlinx.coroutines.launch

class HomeViewModel(private val database: AppDatabase) : ViewModel() {

    val allPlaces: LiveData<List<Place>> = database.placeDao().getAllPlaces()


    fun insert(place: Place) = viewModelScope.launch {
        database.placeDao().insert(place)
    }

    fun delete(place: Place) = viewModelScope.launch {
        database.placeDao().delete(place)
    }

    fun loadPlaces(adapter: PlacesAdapter) {
        allPlaces.observeForever { places ->
            adapter.saveData(places)
        }
    }
    
}

class PlaceViewModelFactory(private val database: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return HomeViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}