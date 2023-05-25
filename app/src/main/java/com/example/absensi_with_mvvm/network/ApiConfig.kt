package com.example.absensi_with_mvvm.network

import com.example.absensi_with_mvvm.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val server : ApiService = retrofit.create(ApiService::class.java)
}