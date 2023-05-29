package com.example.disney.data.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Data(
    @SerializedName("allies")
    val allies: List<Any?>?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("enemies")
    val enemies: List<Any?>?,
    @SerializedName("films")
    val films: List<String?>?,
    @SerializedName("_id")
    val id: Int?,
    @SerializedName("imageUrl")
    val imageUrl: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("parkAttractions")
    val parkAttractions: List<String?>?,
    @SerializedName("shortFilms")
    val shortFilms: List<String?>?,
    @SerializedName("sourceUrl")
    val sourceUrl: String?,
    @SerializedName("tvShows")
    val tvShows: List<String?>?,
    @SerializedName("updatedAt")
    val updatedAt: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("__v")
    val v: Int?,
    @SerializedName("videoGames")
    val videoGames: List<String?>?
) : Serializable