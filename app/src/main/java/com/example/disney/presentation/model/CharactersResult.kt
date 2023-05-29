package com.example.disney.presentation.model

import com.example.disney.data.model.ApiResponse

abstract class CharactersResult {

    class Success(val characters: ApiResponse.Characters): CharactersResult()

    class Error(val errorMessage: String): CharactersResult()
}