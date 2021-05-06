package com.example.thecocktail.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.thecocktail.model.Cocktail
import com.example.thecocktail.model.CocktailEntity
import com.example.thecocktail.model.ListIngredients

fun AppCompatActivity.setUpToolbar(
    toolbar: Toolbar,
    title: String? = null,
    withBackArrow: Boolean = false
) {
    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(withBackArrow)
    title?.let { supportActionBar?.title = it }
}

object Utils {

    fun closeKeyboard(context: Context, view: View) {
        val manager: InputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manager
            .hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun convertListCocktailEntityToListCocktail(listOfFavoritesCocktailFromDb: List<CocktailEntity>): List<Cocktail> {
        return listOfFavoritesCocktailFromDb.map {
            Cocktail(
                it.id,
                it.name,
                it.alcoholic,
                it.video,
                it.glass,
                it.instructions,
                it.image,
                it.ingredient1,
                it.ingredient2,
                it.ingredient3,
                it.ingredient4,
                it.ingredient5,
                it.ingredient6,
                it.ingredient7,
                it.ingredient8,
                it.ingredient9,
                it.ingredient10,
                it.ingredient11,
                it.ingredient12,
                it.ingredient13,
                it.ingredient14,
                it.ingredient15,
                it.measure1,
                it.measure2,
                it.measure3,
                it.measure4,
                it.measure5,
                it.measure6,
                it.measure7,
                it.measure8,
                it.measure9,
                it.measure10,
                it.measure11,
                it.measure12,
                it.measure13,
                it.measure14,
                it.measure15
            )
        }
    }

    fun convertCocktailToCocktailEntity(cocktail: Cocktail): CocktailEntity {
        return CocktailEntity(
            cocktail.id,
            cocktail.name,
            cocktail.alcoholic,
            cocktail.video,
            cocktail.glass,
            cocktail.instructions,
            cocktail.image,
            cocktail.ingredient1,
            cocktail.ingredient2,
            cocktail.ingredient3,
            cocktail.ingredient4,
            cocktail.ingredient5,
            cocktail.ingredient6,
            cocktail.ingredient7,
            cocktail.ingredient8,
            cocktail.ingredient9,
            cocktail.ingredient10,
            cocktail.ingredient11,
            cocktail.ingredient12,
            cocktail.ingredient13,
            cocktail.ingredient14,
            cocktail.ingredient15,
            cocktail.measure1,
            cocktail.measure2,
            cocktail.measure3,
            cocktail.measure4,
            cocktail.measure5,
            cocktail.measure6,
            cocktail.measure7,
            cocktail.measure8,
            cocktail.measure9,
            cocktail.measure10,
            cocktail.measure11,
            cocktail.measure12,
            cocktail.measure13,
            cocktail.measure14,
            cocktail.measure15
        )
    }

    fun convertIngredientsToList(cocktail: Cocktail): List<ListIngredients> {
        val listIngredients: MutableList<ListIngredients> = mutableListOf()
        cocktail.ingredient1?.let {
            listIngredients.add(
                ListIngredients(
                    it,
                    cocktail.measure1 ?: ""
                )
            )
        }
        cocktail.ingredient2?.let {
            listIngredients.add(
                ListIngredients(
                    it,
                    cocktail.measure2 ?: ""
                )
            )
        }
        cocktail.ingredient3?.let {
            listIngredients.add(
                ListIngredients(
                    it,
                    cocktail.measure3 ?: ""
                )
            )
        }
        cocktail.ingredient4?.let {
            listIngredients.add(
                ListIngredients(
                    it,
                    cocktail.measure4 ?: ""
                )
            )
        }
        cocktail.ingredient5?.let {
            listIngredients.add(
                ListIngredients(
                    it,
                    cocktail.measure5 ?: ""
                )
            )
        }
        cocktail.ingredient6?.let {
            listIngredients.add(
                ListIngredients(
                    it,
                    cocktail.measure6 ?: ""
                )
            )
        }
        cocktail.ingredient7?.let {
            listIngredients.add(
                ListIngredients(
                    it,
                    cocktail.measure7 ?: ""
                )
            )
        }
        cocktail.ingredient8?.let {
            listIngredients.add(
                ListIngredients(
                    it,
                    cocktail.measure8 ?: ""
                )
            )
        }
        cocktail.ingredient9?.let {
            listIngredients.add(
                ListIngredients(
                    it,
                    cocktail.measure9 ?: ""
                )
            )
        }
        cocktail.ingredient10?.let {
            listIngredients.add(
                ListIngredients(
                    it,
                    cocktail.measure10 ?: ""
                )
            )
        }
        cocktail.ingredient11?.let {
            listIngredients.add(
                ListIngredients(
                    it,
                    cocktail.measure11 ?: ""
                )
            )
        }
        cocktail.ingredient12?.let {
            listIngredients.add(
                ListIngredients(
                    it,
                    cocktail.measure12 ?: ""
                )
            )
        }
        cocktail.ingredient13?.let {
            listIngredients.add(
                ListIngredients(
                    it,
                    cocktail.measure13 ?: ""
                )
            )
        }
        cocktail.ingredient14?.let {
            listIngredients.add(
                ListIngredients(
                    it,
                    cocktail.measure14 ?: ""
                )
            )
        }
        cocktail.ingredient15?.let {
            listIngredients.add(
                ListIngredients(
                    it,
                    cocktail.measure15 ?: ""
                )
            )
        }
        return listIngredients.toList()
    }
}
