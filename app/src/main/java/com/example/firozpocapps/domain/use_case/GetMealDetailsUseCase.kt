package com.example.firozpocapps.domain.use_case

import com.example.firozpocapps.common.Resource
import com.example.firozpocapps.data.model.toDomainMeal
import com.example.firozpocapps.data.model.toDomainMealDetails
import com.example.firozpocapps.domain.model.MealDetails
import com.example.firozpocapps.domain.repository.GetMealDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMealDetailsUseCase @Inject constructor(private val repository: GetMealDetailsRepository) {

    operator fun invoke(id:String): Flow<Resource<MealDetails>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getMealDetails(id).meals[0].toDomainMealDetails()
            emit(Resource.Success(data = response))
        }catch (e:HttpException){
            emit(Resource.Error(message = e.localizedMessage?:"UnKnown error"))
        }catch (e:IOException){
            emit(Resource.Error(message = e.localizedMessage?:"Check internet connection"))
        }
    }
}