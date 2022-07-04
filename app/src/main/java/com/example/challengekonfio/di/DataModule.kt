package com.example.challengekonfio.di

import com.example.challengekonfio.core.BaseServiceClient
import com.example.challengekonfio.data.repository.DogsRepository
import com.example.challengekonfio.data.repository.DogsRepositoryImpl
import com.example.challengekonfio.domain.UseCaseDog
import com.example.challengekonfio.domain.UseCaseDogImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindUseCase(useCaseDogImpl: UseCaseDogImpl): UseCaseDog

    @Binds
    abstract fun bindRepository(dogsRepositoryImpl: DogsRepositoryImpl): DogsRepository

    companion object {

        @Provides
        fun provideRegisterService(retrofit: Retrofit.Builder): BaseServiceClient =
            retrofit
                .build()
                .create(BaseServiceClient::class.java)

    }
}