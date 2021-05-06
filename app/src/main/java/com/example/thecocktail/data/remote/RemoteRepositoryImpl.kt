package com.example.thecocktail.data.remote

import com.example.thecocktail.model.Cocktail
import com.example.thecocktail.util.Resource
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(private val dataSource: RemoteDataSource) :
    RemoteRepository {
    override suspend fun getCocktailByName(nameCocktail: String): Resource<List<Cocktail>> {
        return dataSource.getCocktailByName(nameCocktail)
    }
}