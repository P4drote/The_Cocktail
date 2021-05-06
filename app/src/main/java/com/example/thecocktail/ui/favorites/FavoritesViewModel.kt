package com.example.thecocktail.ui.favorites

import androidx.lifecycle.*
import com.example.thecocktail.data.local.LocalRepository
import com.example.thecocktail.model.CocktailEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(private val localRepository: LocalRepository) :
    ViewModel() {

    val listOfFavoritesCocktail = MutableLiveData<List<CocktailEntity>>()

    init {
        getListOfFavoritesCocktail()
    }

    private fun getListOfFavoritesCocktail() {
        viewModelScope.launch {
            listOfFavoritesCocktail.value = localRepository.getAllCocktail()
        }
    }

}