package com.example.firozpocapps.data.repository

import com.example.firozpocapps.data.model.MealsDTO
import com.example.firozpocapps.data.remote.MealSearchAPI
import com.example.firozpocapps.domain.repository.MealSearchRepository

class GetMealListImpl(private val mealSearchAPI: MealSearchAPI) : MealSearchRepository {
    override suspend fun getMealList(s: String): MealsDTO {
        return mealSearchAPI.getMealList(s)
    }
}