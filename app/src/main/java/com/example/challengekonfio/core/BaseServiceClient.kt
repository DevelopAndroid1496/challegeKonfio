package com.example.challengekonfio.core

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class BaseServiceClient @Inject constructor() {


    operator fun invoke(): Retrofit.Builder {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClientBuilder = OkHttpClient().newBuilder()
        okHttpClientBuilder.interceptors().clear()
        okHttpClientBuilder
            .addInterceptor(loggingInterceptor)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .retryOnConnectionFailure(true)

        val client: OkHttpClient = okHttpClientBuilder.build()

        return  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
    }

    companion object{
        const val BASE_URL = "https://jsonblob.com/"
    }

}
