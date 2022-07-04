package com.example.challengekonfio.di

import com.example.challengekonfio.data.net.ApiDogs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    companion object {
        @Provides
        fun provideRetrofit(retrofit: Retrofit.Builder): ApiDogs =
            retrofit
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiDogs::class.java)
    }

}