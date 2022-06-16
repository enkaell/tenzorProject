package com.example.tenzorproject

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDAO {
    @Query("SELECT * FROM  pokemon_table ORDER BY lastUpdate")
    fun getPokemonsByDate(): Flow<List<PokemonEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pokemonEntity: PokemonEntity)

    @Query("DELETE FROM pokemon_table")
    suspend fun deleteAll()

}