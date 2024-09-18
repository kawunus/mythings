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

    fun loadPlaces(adapter: PlacesAdapter) {
        allPlaces.observeForever { places ->
            adapter.saveData(places)
        }
    }

}