package com.example.disney.data.model

import com.google.gson.annotations.SerializedName

sealed class ApiResponse {
    data class CharacterByName(
        @SerializedName("data")
        val data: Data?,
        @SerializedName("info")
        val info: Info?
    ) : ApiResponse() {
        constructor() : this(null, null)
    }

    data class Characters(
        @SerializedName("data")
        val data: List<Data?>,
        @SerializedName("info")
        val info: Info?
    ) : ApiResponse() {
        constructor() : this(emptyList(), null)
    }
}