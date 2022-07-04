package com.example.challengekonfio.di

import com.example.challengekonfio.core.BaseServiceClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.AliasOf
import retrofit2.Retrofit
import javax.inject.Scope
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule() {

    @AppScope
    @Provides
    fun provideRetrofit(serviceObject: BaseServiceClient): Retrofit.Builder = serviceObject()

    @Scope
    @AliasOf(Singleton::class)
    annotation class AppScope
}