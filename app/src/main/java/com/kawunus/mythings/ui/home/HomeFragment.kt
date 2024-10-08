package com.kawunus.mythings.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kawunus.mythings.R
import com.kawunus.mythings.data.DatabaseProvider
import com.kawunus.mythings.databinding.FragmentHomeBinding
import com.kawunus.mythings.ui.adapter.places.PlacesAdapter
import com.kawunus.mythings.util.ViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val database = DatabaseProvider.getDatabase(requireContext())
        viewModel = ViewModelProvider(this, ViewModelFactory(database))[HomeViewModel::class.java]

        val adapter = PlacesAdapter()
        binding.recyclewView.adapter = adapter
        viewModel.loadPlaces(adapter)

        binding.addPlaceImageView.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.action_homeFragment_to_newPlaceFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
}