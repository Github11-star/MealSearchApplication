package com.example.firozpocapps.hilt

import com.example.firozpocapps.common.Constants
import com.example.firozpocapps.data.remote.MealSearchAPI
import com.example.firozpocapps.data.repository.GetMealDetailsImpl
import com.example.firozpocapps.data.repository.GetMealListImpl
import com.example.firozpocapps.domain.repository.GetMealDetailsRepository
import com.example.firozpocapps.domain.repository.MealSearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HiltModules {

    @Provides
    @Singleton
    fun provideMealSearchAPI(): MealSearchAPI {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(MealSearchAPI::class.java)
    }

    @Provides
    fun provideMealSearchRepository(mealSearchAPI: MealSearchAPI): MealSearchRepository{
        return GetMealListImpl(mealSearchAPI)
    }

    @Provides
    fun provideMealDetailsRepository(mealSearchAPI: MealSearchAPI): GetMealDetailsRepository{
        return GetMealDetailsImpl(mealSearchAPI)
    }
}