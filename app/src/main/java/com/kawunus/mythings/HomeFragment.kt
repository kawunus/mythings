package com.kawunus.mythings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kawunus.mythings.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val database = DatabaseProvider.getDatabase(requireContext())
        viewModel =
            ViewModelProvider(this, PlaceViewModelFactory(database))[HomeViewModel::class.java]
        viewModel.allPlaces.observe(viewLifecycleOwner) { places ->
            val adapter = PlacesAdapter()
            binding.recyclewView.adapter = adapter
            (binding.recyclewView.adapter as PlacesAdapter).saveData(places)
            Log.e("DB", places.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
}