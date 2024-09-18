package com.kawunus.mythings.ui.newplace

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kawunus.mythings.R
import com.kawunus.mythings.data.AppDatabase
import com.kawunus.mythings.model.Place
import com.kawunus.mythings.ui.home.HomeViewModel
import kotlinx.coroutines.launch

class NewPlaceViewModel(private val database: AppDatabase) : ViewModel() {

    fun insert(name: String) = viewModelScope.launch {
        database.placeDao().insert(Place(name = name))
    }
}

class NewPlaceViewModelFactory(private val database: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewPlaceViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return NewPlaceViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}