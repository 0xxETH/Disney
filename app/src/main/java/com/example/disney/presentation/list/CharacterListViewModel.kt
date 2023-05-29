package com.example.disney.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disney.domain.CharactersUseCase
import com.example.disney.presentation.model.CharactersResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterListViewModel : ViewModel() {

    private val charactersUseCase = CharactersUseCase()
    private val charactersLiveData = MutableLiveData<CharactersResult>()

    fun loadCharactersByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val characters = charactersUseCase.getCharactersByName(name)
            charactersLiveData.postValue(characters)
        }
    }

    fun loadAllCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            val characters = charactersUseCase.getAllCharacters()
            charactersLiveData.postValue(characters)
        }
    }

    fun charactersLiveData(): LiveData<CharactersResult> {
        return charactersLiveData
    }
}