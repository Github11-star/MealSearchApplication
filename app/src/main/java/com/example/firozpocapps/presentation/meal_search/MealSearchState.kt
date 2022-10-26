package com.example.firozpocapps.presentation.meal_search

import com.example.firozpocapps.domain.model.Meal

data class MealSearchState(
    val data : List<Meal>? = null,
    val error: String = "",
    val isLoading: Boolean = false
)