package com.example.disney.domain

import com.example.disney.data.Repository
import com.example.disney.presentation.model.CharactersResult

class CharactersUseCase {

    private val repository = Repository()

    suspend fun getAllCharacters(): CharactersResult {
        return repository.getAllCharacters()
    }

    suspend fun getCharactersByName(name: String): CharactersResult {
        return repository.getCharactersByName(name)
    }

}