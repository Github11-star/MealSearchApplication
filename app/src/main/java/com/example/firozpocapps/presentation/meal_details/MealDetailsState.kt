package com.example.firozpocapps.presentation.meal_details

import com.example.firozpocapps.domain.model.MealDetails

data class MealDetailsState(
    val data: MealDetails? = null,
    val error: String = "",
    val isLoading: Boolean = false
)
