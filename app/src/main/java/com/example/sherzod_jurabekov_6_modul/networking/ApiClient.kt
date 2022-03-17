package com.example.sherzod_jurabekov_6_modul.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    var BASE_URL = "https://623317b56de3467dbac836bc.mockapi.io/cards/"

    fun getRetrofit(): Retrofit {
        val build = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return build
    }

    fun <T> createService(service: Class<T>): T{
        return getRetrofit().create(service)
    }
}