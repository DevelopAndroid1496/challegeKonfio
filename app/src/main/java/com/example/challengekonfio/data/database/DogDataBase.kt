package com.example.challengekonfio.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.challengekonfio.data.database.dao.DogDao
import com.example.challengekonfio.data.database.entities.DogEntity

@Database(entities = [DogEntity::class], version = 1)
abstract class DogDataBase: RoomDatabase() {

    abstract fun getDogDao(): DogDao
}