package com.example.thecocktail.data.remote

import com.example.thecocktail.domain.WebService
import com.example.thecocktail.model.Cocktail
import com.example.thecocktail.util.Resource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val webService: WebService):
    RemoteDataSource {
    override suspend fun getCocktailByName(nameCocktail: String): Resource<List<Cocktail>> {
        return Resource.Success(webService.getCocktails(nameCocktail).listCocktail)
    }
}