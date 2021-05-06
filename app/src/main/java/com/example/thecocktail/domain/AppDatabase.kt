package com.example.thecocktail.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.thecocktail.model.CocktailEntity

@Database(entities = [CocktailEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao
}