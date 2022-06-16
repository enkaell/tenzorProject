package com.example.tenzorproject

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class PokemonRepository(private val pokemonDAO: PokemonDAO) {
    val pokemonByDate: Flow<List<PokemonEntity>> = pokemonDAO.getPokemonsByDate()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(pokemonEntity: PokemonEntity) {
        pokemonDAO.insert(pokemonEntity)
    }

}