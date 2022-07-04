package com.example.challengekonfio.data.repository

import com.example.challengekonfio.data.database.dao.DogDao
import com.example.challengekonfio.data.database.entities.DogEntity
import com.example.challengekonfio.data.database.entities.toDatabase
import com.example.challengekonfio.data.model.DogResponse
import com.example.challengekonfio.data.net.ApiDogs
import com.example.challengekonfio.domain.model.Dog
import com.example.challengekonfio.domain.model.toDomain
import com.example.challengekonfio.utils.BaseError
import com.example.challengekonfio.utils.DataState
import com.example.challengekonfio.utils.PrefsHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class DogsRepositoryImpl @Inject constructor(private var service: ApiDogs,private var dogDao: DogDao, private var prefsHelper: PrefsHelper) : DogsRepository{


    override suspend fun getListDogs(): Flow<DataState<ArrayList<Dog>>> = flow {

        if (service.getListDogs().isSuccessful){
            service.getListDogs().body()?.let { dogs ->
                when(service.getListDogs().code()){
                    200 ->{
                        if (dogs.isNotEmpty()){
                            prefsHelper.oneTime = false
                            val dogsModel = dogs.map { it.toDomain() }
                            insertAllDogs(dogsModel.map { it.toDatabase() } as ArrayList<DogEntity> )
                            emit(DataState.Success(data = (service.getListDogs().body()!!.map { it.toDomain() } as ArrayList<Dog>)))
                        }
                    }else -> {
                        emit(DataState.Error(BaseError(cause = "Operación no realizada", code = service.getListDogs().code())))
                    }
                }
            }
        }
    }

    override suspend fun getDogsFromDB(): Flow<DataState<ArrayList<Dog>>> = flow {
        val dogsModel = dogDao.getAllDogsFromDB()
        val dogs = dogsModel.map { it.toDomain() }
        val arrayDogs: ArrayList<Dog> = ArrayList()
        for(i in dogs){ arrayDogs.add(Dog(i.dogName,i.description,i.age,i.image)) }
        emit(DataState.Success(arrayDogs))
    }

    override suspend fun insertAllDogs(listDogs: ArrayList<DogEntity>) { dogDao.insertAllDogsToDB(listDogs) }

}