package com.kawunus.mythings.ui.newplace

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawunus.mythings.R
import com.kawunus.mythings.data.AppDatabase
import com.kawunus.mythings.model.Place
import kotlinx.coroutines.launch

class NewPlaceViewModel(private val database: AppDatabase) : ViewModel() {

    fun insert(name: String) = viewModelScope.launch {
        database.placeDao().insert(Place(name = name))
    }
}