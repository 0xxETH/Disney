package com.example.disney.data

import com.example.disney.data.model.ApiResponse
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class ApiResponseDeserializer : JsonDeserializer<ApiResponse> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): ApiResponse {
        val jsonObject = json.asJsonObject

        return when {
            jsonObject.has("data") && jsonObject.get("data").isJsonArray -> {
                context.deserialize(json, ApiResponse.Characters::class.java)
            }
            else -> {
                context.deserialize(json, ApiResponse.CharacterByName::class.java)
            }
        }
    }
}