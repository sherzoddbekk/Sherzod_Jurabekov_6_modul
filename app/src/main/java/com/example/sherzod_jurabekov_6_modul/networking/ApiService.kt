package com.example.sherzod_jurabekov_6_modul.networking

import com.example.sherzod_jurabekov_6_modul.model.CardElement
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("cards")
    fun getCards(): Call<ArrayList<CardElement>>

    @POST("cards")
    fun createCards(@Body card:CardElement)
}