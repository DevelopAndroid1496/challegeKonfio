package com.example.challengekonfio.data.net

import com.example.challengekonfio.data.model.DogResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiDogs {

    @GET("api/945366962796773376")
    suspend fun getListDogs() : Response<ArrayList<DogResponse>>
}