package com.example.disney.data

import com.example.disney.data.model.ApiResponse
import com.example.disney.presentation.model.CharactersResult
import java.lang.Exception
import java.net.UnknownHostException

class Repository {

    private val disneyApi = RetrofitInstance.disneyApi

    suspend fun getAllCharacters(): CharactersResult {
        return try {
            CharactersResult.Success(disneyApi.getAllCharacters() as ApiResponse.Characters)
        } catch (e: Exception) {
            if (e is UnknownHostException) {
                CharactersResult.Error("No Internet connection!")
            } else {
                CharactersResult.Error(e.message.toString())
            }
        }
    }

    suspend fun getCharactersByName(name: String): CharactersResult {
        return try {
//            val charactersByName = disneyApi.getCharactersByName(name)
//            val characters = Characters(listOf(charactersByName.data), charactersByName.info)
//            CharactersResult.Success(characters)
            val characters = disneyApi.getCharactersByName(name)
            if (characters is ApiResponse.CharacterByName) {
                CharactersResult.Success(ApiResponse.Characters(listOf(characters.data), characters.info))
            } else {
                CharactersResult.Success(characters as ApiResponse.Characters)
            }
        } catch (e: Exception) {
            if (e is UnknownHostException) {
                CharactersResult.Error("No Internet connection!")
            } else {
                CharactersResult.Error(e.message.toString())
            }
        }
    }
}