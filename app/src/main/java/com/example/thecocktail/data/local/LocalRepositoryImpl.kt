package com.example.thecocktail.data.local

import com.example.thecocktail.model.CocktailEntity
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(private val dataSource: LocalDataSource): LocalRepository {

    override suspend fun getAllCocktail(): List<CocktailEntity> {
        return dataSource.getAllCocktail()
    }

    override suspend fun isFavorite(id: String): Boolean {
        return dataSource.isFavorite(id)
    }

    override suspend fun saveFavoriteCocktail(cocktail: CocktailEntity) {
        dataSource.saveFavoriteCocktail(cocktail)
    }

    override suspend fun deleteFavoriteCocktail(cocktail: CocktailEntity) {
        dataSource.deleteFavoriteCocktail(cocktail)
    }
}