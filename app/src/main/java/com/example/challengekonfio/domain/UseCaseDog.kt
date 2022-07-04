package com.example.challengekonfio.domain

import com.example.challengekonfio.data.model.DogResponse
import com.example.challengekonfio.domain.model.Dog
import com.example.challengekonfio.utils.DataState
import kotlinx.coroutines.flow.Flow

interface UseCaseDog {
    suspend fun getListDogs() : Flow<DataState<ArrayList<Dog>>>
}