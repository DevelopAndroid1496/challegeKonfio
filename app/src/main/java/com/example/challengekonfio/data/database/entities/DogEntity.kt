package com.example.challengekonfio.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.challengekonfio.domain.model.Dog

@Entity(tableName = "dog_table")
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int = 0,
    @ColumnInfo(name = "dogName") var dogName: String,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "age") var age: Int,
    @ColumnInfo(name = "image") var image: String

)

fun Dog.toDatabase() = DogEntity(dogName = dogName, description = description, age = age, image = image)