package com.example.thecocktail.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thecocktail.data.local.LocalRepository
import com.example.thecocktail.model.Cocktail
import com.example.thecocktail.model.CocktailEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val localRepository: LocalRepository) :
    ViewModel() {

    val isFavorite = MutableLiveData<Boolean>()

    fun getIsFavorite(cocktailId: String) {
        viewModelScope.launch { isFavorite.value = localRepository.isFavorite(cocktailId) }
    }

    fun deleteFavoriteCocktail(cocktail: CocktailEntity) {
        viewModelScope.launch { localRepository.deleteFavoriteCocktail(cocktail) }
        isFavorite.value = false
    }

    fun saveFavoriteCocktail(cocktail: CocktailEntity) {
        viewModelScope.launch { localRepository.saveFavoriteCocktail(cocktail) }
        isFavorite.value = true
    }
}