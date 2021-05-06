package com.example.thecocktail.data.local

import com.example.thecocktail.model.CocktailEntity

interface LocalDataSource {
    suspend fun getAllCocktail(): List<CocktailEntity>
    suspend fun isFavorite(id: String): Boolean
    suspend fun saveFavoriteCocktail(cocktail: CocktailEntity)
    suspend fun deleteFavoriteCocktail(cocktail: CocktailEntity)
}