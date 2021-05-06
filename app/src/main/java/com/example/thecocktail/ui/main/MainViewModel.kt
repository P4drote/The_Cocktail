package com.example.thecocktail.ui.main

import androidx.lifecycle.*
import com.example.thecocktail.data.remote.RemoteRepository
import com.example.thecocktail.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(private val repository: RemoteRepository): ViewModel() {

    private val cocktailName = MutableLiveData<String>()

    init {
        cocktailToSearch("margarita")
    }

    fun cocktailToSearch(name: String) {
        cocktailName.value = name
//        name.split("a").mapIndexed { index, s -> if (index != 0) {
//            s.capitalize(Locale.ROOT) }else { index } }
    }

    val getCocktail = cocktailName.distinctUntilChanged().switchMap {
        liveData(Dispatchers.IO) {
            emit(Resource.Loading)
            try {
                emit(repository.getCocktailByName(it))
            }catch (e: Exception){
                emit(Resource.Failure(e))
            }
        }
    }
}