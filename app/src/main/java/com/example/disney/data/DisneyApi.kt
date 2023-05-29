package com.example.disney.data

import com.example.disney.data.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface DisneyApi {

    @Headers("Content-Type: application/json")
    @GET("character")
    suspend fun getAllCharacters(): ApiResponse

    @Headers("Content-Type: application/json")
    @GET("character")
    suspend fun getCharactersByName(@Query("name") name: String): ApiResponse

}