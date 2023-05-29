package com.example.disney.data

import com.example.disney.data.model.ApiResponse
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val client = OkHttpClient.Builder().build()

    val gson = GsonBuilder()
        .registerTypeAdapter(ApiResponse::class.java, ApiResponseDeserializer())
        .create()

    val disneyApi: DisneyApi = Retrofit.Builder()
        .baseUrl("https://api.disneyapi.dev/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()
        .create(DisneyApi::class.java)

}