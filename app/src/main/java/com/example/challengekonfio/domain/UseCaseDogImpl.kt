package com.example.challengekonfio.domain

import com.example.challengekonfio.data.model.DogResponse
import com.example.challengekonfio.data.repository.DogsRepository
import com.example.challengekonfio.domain.model.Dog
import com.example.challengekonfio.utils.DataState
import com.example.challengekonfio.utils.PrefsHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class UseCaseDogImpl @Inject constructor(private var repository: DogsRepository, private val prefs: PrefsHelper? = null) : UseCaseDog{

    override suspend fun getListDogs(): Flow<DataState<ArrayList<Dog>>> = flow {

        if (prefs!!.oneTime){
            repository.getListDogs()
                .catch{ e -> e.printStackTrace()}
                .collect{ stateDog ->
                    emit(stateDog)

                }
        }else{
            repository.getDogsFromDB()
                .catch { e -> e.printStackTrace() }
                .collect { stateDogDb ->
                    emit(stateDogDb)
                }
        }


    }.flowOn(Dispatchers.IO)

}