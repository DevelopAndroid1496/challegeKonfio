package com.example.challengekonfio.di

import android.content.Context
import androidx.room.Room
import com.example.challengekonfio.data.database.DogDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "database"

    @Singleton
    @Provides
    fun provieRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context,DogDataBase::class.java,
        DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provdeDogDao(db: DogDataBase) = db.getDogDao()

}