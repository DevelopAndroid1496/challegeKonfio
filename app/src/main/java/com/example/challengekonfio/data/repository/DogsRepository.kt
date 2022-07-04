package com.example.challengekonfio.data.repository

import com.example.challengekonfio.data.database.entities.DogEntity
import com.example.challengekonfio.data.model.DogResponse
import com.example.challengekonfio.domain.model.Dog
import com.example.challengekonfio.utils.DataState
import kotlinx.coroutines.flow.Flow


interface DogsRepository {

    suspend fun getListDogs(): Flow<DataState<ArrayList<Dog>>>

    suspend fun getDogsFromDB(): Flow<DataState<ArrayList<Dog>>>

    suspend fun insertAllDogs(listDogs: ArrayList<DogEntity>)
}