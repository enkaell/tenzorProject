package com.example.tenzorproject

import androidx.lifecycle.*
import kotlinx.coroutines.launch


class PokemonViewModel(private val repository: PokemonRepository): ViewModel() {
    val allWords: LiveData<List<PokemonEntity>> = repository.pokemonByDate.asLiveData()

    fun insert(pokemonEntity: PokemonEntity) = viewModelScope.launch {
        repository.insert(pokemonEntity)
    }
}

class PokemonViewModelFactory(private val repository: PokemonRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return PokemonViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}