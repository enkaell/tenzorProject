package com.example.tenzorproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(PokemonEntity::class), version = 1, exportSchema = false)
public abstract  class PokeDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDAO

    companion object {

        @Volatile
        private var INSTANCE: PokeDatabase? = null

        fun getDatabase(context: Context): PokeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PokeDatabase::class.java,
                    "pokemon_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}