package com.example.tenzorproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_table")
class PokemonEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "poke_name") val name: String,
    @ColumnInfo(name = "weight") val weight: String,
    @ColumnInfo(name = "comment") val comment: String,
    @ColumnInfo(name = "lastUpdate") val lastUpdate: String?
)