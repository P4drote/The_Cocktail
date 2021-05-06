package com.example.thecocktail.domain

import com.example.thecocktail.model.ListCocktail
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("search.php?s=")
    suspend fun getCocktails(@Query("s") name: String): ListCocktail
}