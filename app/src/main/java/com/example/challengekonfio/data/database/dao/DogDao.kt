package com.example.challengekonfio.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.challengekonfio.data.database.entities.DogEntity

@Dao
interface DogDao {

    @Query("SELECT * FROM dog_table")
    suspend fun getAllDogsFromDB(): List<DogEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDogsToDB(dogs: List<DogEntity>)
}