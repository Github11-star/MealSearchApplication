package com.example.firozpocapps.presentation.meal_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.firozpocapps.R
import com.example.firozpocapps.databinding.FragmentMealDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MealDetailsFragment : Fragment() {

    private var _binding: FragmentMealDetailsBinding? = null
    private val binding: FragmentMealDetailsBinding
        get() = _binding!!

    private val viewModel: MealDetailsViewModel by viewModels()

    private val args: MealDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMealDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        args.mealId?.let {
            viewModel.getMealDetails(it)
        }

        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.mealDetails.collect {
                if (it.isLoading) {
                    binding.progressMealDetails.visibility = View.VISIBLE
                }
                if (it.error.isNotBlank()) {
                    binding.progressMealDetails.visibility = View.GONE
                    Toast.makeText(requireContext(),it.error,Toast.LENGTH_LONG).show()
                }
                it.data?.let {
                    binding.progressMealDetails.visibility = View.GONE
                    binding.mealDetails = it
                }
            }
        }

        binding.detailsBackArrow.setOnClickListener{
            findNavController().popBackStack()
        }
    }
}