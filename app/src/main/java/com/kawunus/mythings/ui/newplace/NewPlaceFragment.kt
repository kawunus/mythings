package com.kawunus.mythings.ui.newplace

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kawunus.mythings.data.DatabaseProvider
import com.kawunus.mythings.databinding.FragmentNewPlaceBinding

class NewPlaceFragment : Fragment() {

    private lateinit var viewModel: NewPlaceViewModel
    private lateinit var binding: FragmentNewPlaceBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = DatabaseProvider.getDatabase(requireContext())
        viewModel = ViewModelProvider(
            this, NewPlaceViewModelFactory(database)
        )[NewPlaceViewModel::class.java]


        binding.arrowBackImageView.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.createTextView.setOnClickListener {
            viewModel.insert(binding.nameEditText.text.toString())
            findNavController().popBackStack()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewPlaceBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
}