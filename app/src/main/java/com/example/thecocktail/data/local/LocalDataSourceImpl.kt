package com.example.thecocktail.data.local

import com.example.thecocktail.domain.CocktailDao
import com.example.thecocktail.model.CocktailEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class LocalDataSourceImpl @Inject constructor(private var cocktailDao: CocktailDao): LocalDataSource {
    override suspend fun getAllCocktail(): List<CocktailEntity> {
        return withContext(Dispatchers.IO) { cocktailDao.getAllCocktail() }
    }

    override suspend fun isFavorite(id: String): Boolean {
        return withContext(Dispatchers.IO) { cocktailDao.isFavorite(id) == 1}
    }

    override suspend fun saveFavoriteCocktail(cocktail: CocktailEntity) {
        withContext(Dispatchers.IO) { cocktailDao.saveFavoriteCocktail(cocktail) }
    }

    override suspend fun deleteFavoriteCocktail(cocktail: CocktailEntity) {
        withContext(Dispatchers.IO) { cocktailDao.deleteFavoriteCocktail(cocktail) }
    }
}
