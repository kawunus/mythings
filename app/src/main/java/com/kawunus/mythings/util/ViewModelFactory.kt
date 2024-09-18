package com.kawunus.mythings.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kawunus.mythings.data.AppDatabase
import com.kawunus.mythings.ui.home.HomeViewModel
import com.kawunus.mythings.ui.newplace.NewPlaceViewModel

class ViewModelFactory(private val database: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewPlaceViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return NewPlaceViewModel(database) as T
        }
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return HomeViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}