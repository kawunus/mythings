package com.kawunus.mythings.ui.newplace

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kawunus.mythings.R
import com.kawunus.mythings.databinding.FragmentNewPlaceBinding

class NewPlaceFragment : Fragment() {

    private val viewModel: NewPlaceViewModel by viewModels()
    private lateinit var binding: FragmentNewPlaceBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.arrowBackImageView.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.createTextView.setOnClickListener {
            
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewPlaceBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
}