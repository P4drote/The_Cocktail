package com.example.thecocktail.domain

import androidx.room.*
import com.example.thecocktail.model.CocktailEntity

@Dao
interface CocktailDao {

    @Query("SELECT * FROM table_cocktail")
    suspend fun getAllCocktail(): List<CocktailEntity>

    @Query("SELECT count(*) FROM table_cocktail WHERE id = :id")
    suspend fun isFavorite(id: String): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFavoriteCocktail(cocktail: CocktailEntity)

    @Delete
    suspend fun deleteFavoriteCocktail(cocktail: CocktailEntity)
}