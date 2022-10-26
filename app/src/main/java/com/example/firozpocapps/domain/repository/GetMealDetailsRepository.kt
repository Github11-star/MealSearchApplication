package com.example.firozpocapps.domain.repository

import com.example.firozpocapps.data.model.MealsDTO

interface GetMealDetailsRepository {

    suspend fun getMealDetails(id: String): MealsDTO
}