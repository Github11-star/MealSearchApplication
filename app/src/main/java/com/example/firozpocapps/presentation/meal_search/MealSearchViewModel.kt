package com.example.firozpocapps.presentation.meal_search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firozpocapps.domain.use_case.GetMealSearchListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MealSearchViewModel @Inject constructor(
    private val getMealSearchListUseCase: GetMealSearchListUseCase
    ) : ViewModel() {

        private val _mealSearchList = MutableStateFlow<MealSearchState>(MealSearchState())
        val mealSearchList: StateFlow<MealSearchState> = _mealSearchList

        private val _query: MutableLiveData<String> = MutableLiveData()

    fun searchMealList(s: String){
        getMealSearchListUseCase(s).onEach {

        }
    }
}