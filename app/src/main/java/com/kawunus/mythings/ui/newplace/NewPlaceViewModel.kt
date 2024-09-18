package com.kawunus.mythings.ui.newplace

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.kawunus.mythings.R

class NewPlaceViewModel : ViewModel() {

    fun replaceFragment(fragment: Fragment, fragmentManager: FragmentManager){
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }
}