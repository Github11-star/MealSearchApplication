package com.example.firozpocapps.data.repository

import com.example.firozpocapps.data.model.MealsDTO
import com.example.firozpocapps.data.remote.MealSearchAPI
import com.example.firozpocapps.domain.repository.GetMealDetailsRepository

class GetMealDetailsImpl(private val mealSearchAPI: MealSearchAPI) : GetMealDetailsRepository {
    override suspend fun getMealDetails(id: String): MealsDTO {
        return mealSearchAPI.getMealDetails(id)
    }

}