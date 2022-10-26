package com.example.firozpocapps.presentation.meal_search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.adapters.SearchViewBindingAdapter.setOnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import com.example.firozpocapps.R
import com.example.firozpocapps.databinding.FragmentMealSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealSearchFragment : Fragment() {

    private var _binding: FragmentMealSearchBinding? = null
    val binding: FragmentMealSearchBinding
    get() = _binding!!

    private val mealSearchViewModel: MealSearchViewModel by viewModels()

    private val mealSearchAdapter = MealSearchAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMealSearchBinding.inflate(inflater,container,false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.searchMeal.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String?): Boolean {
                s?.let {
                    mealSearchViewModel.searchMealList(s)
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })

        binding.searchRecycler.apply {
            adapter = mealSearchAdapter
        }

        lifecycle.coroutineScope.launchWhenCreated {
            mealSearchViewModel.mealSearchList.collect{
                if (it.isLoading){
                    binding.progressMealSearch.visibility=View.VISIBLE
                }
                if (it.error.isNotBlank()){
                    binding.progressMealSearch.visibility=View.GONE
                }

                it.data?.let {
                    binding.progressMealSearch.visibility=View.GONE
                    mealSearchAdapter.setContentList(it.toMutableList())
                }
            }
        }
    }




}