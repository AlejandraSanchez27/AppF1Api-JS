package com.appf1api.appf1api.core.network

import com.appf1api.appf1api.authapp.data.remote.F1ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object F1RetrofitClient {
    private const val BASE_URL = "https://api.jolpi.ca/"
    val api: F1ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(F1ApiService::class.java)
    }
}