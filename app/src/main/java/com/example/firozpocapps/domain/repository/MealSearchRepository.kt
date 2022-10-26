package com.example.firozpocapps.domain.repository

import com.example.firozpocapps.data.model.MealsDTO

interface MealSearchRepository {

    suspend fun getMealList(s: String): MealsDTO
}