package com.kawunus.mythings.ui.newplace

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kawunus.mythings.data.DatabaseProvider
import com.kawunus.mythings.databinding.FragmentNewPlaceBinding
import com.kawunus.mythings.util.ViewModelFactory
import com.kawunus.mythings.ui.newplace.NewPlaceViewModel.InsertCodes

class NewPlaceFragment : Fragment() {

    private lateinit var viewModel: NewPlaceViewModel
    private lateinit var binding: FragmentNewPlaceBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = DatabaseProvider.getDatabase(requireContext())
        viewModel = ViewModelProvider(
            this, ViewModelFactory(database)
        )[NewPlaceViewModel::class.java]


        binding.arrowBackImageView.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.createTextView.setOnClickListener {
            insert(binding.nameEditText.text.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewPlaceBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    private fun insert(name: String) {

        val code = viewModel.insert(name)

        when (code) {
            InsertCodes.EXIST -> {
                showErrorMessage("Такое место уже существует в базе данных.")
            }
            InsertCodes.EMPTY_NAME -> {
                showErrorMessage("Имя места не может быть пустым.")
            }
            InsertCodes.SUCCESSFUL -> {
                showErrorMessage("Место успешно добавлено.")
                findNavController().popBackStack()
            }
            else -> {
                showErrorMessage("Неизвестный код вставки.")
            }
        }
    }

    private fun showErrorMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}