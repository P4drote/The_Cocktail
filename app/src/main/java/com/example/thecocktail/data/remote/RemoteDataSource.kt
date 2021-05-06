package com.example.thecocktail.data.remote

import com.example.thecocktail.model.Cocktail
import com.example.thecocktail.util.Resource

interface RemoteDataSource {
    suspend fun getCocktailByName(nameCocktail: String): Resource<List<Cocktail>>
}