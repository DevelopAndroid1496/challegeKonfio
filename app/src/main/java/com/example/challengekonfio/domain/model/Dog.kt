package com.example.challengekonfio.domain.model

import com.example.challengekonfio.data.database.entities.DogEntity
import com.example.challengekonfio.data.model.DogResponse

data class Dog(var dogName: String, var description: String, var age: Int, var image: String)

fun DogResponse.toDomain() = Dog(dogname,description,age,url)
fun DogEntity.toDomain() = Dog(dogName,description,age,image)
