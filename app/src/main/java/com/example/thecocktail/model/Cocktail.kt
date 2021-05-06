package com.example.thecocktail.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cocktail(
    @SerializedName("idDrink")
    val id: String = "",
    @SerializedName("strDrink")
    val name: String = "",
    @SerializedName("strAlcoholic")
    val alcoholic: String = "",
    @SerializedName("strVideo")
    val video: String? = null,
    @SerializedName("strGlass")
    val glass: String = "",
    @SerializedName("strInstructions")
    val instructions: String = "",
    @SerializedName("strDrinkThumb")
    val image: String = "",
    @SerializedName("strIngredient1")
    val ingredient1: String? = null,
    @SerializedName("strIngredient2")
    val ingredient2: String? = null,
    @SerializedName("strIngredient3")
    val ingredient3: String? = null,
    @SerializedName("strIngredient4")
    val ingredient4: String? = null,
    @SerializedName("strIngredient5")
    val ingredient5: String? = null,
    @SerializedName("strIngredient6")
    val ingredient6: String? = null,
    @SerializedName("strIngredient7")
    val ingredient7: String? = null,
    @SerializedName("strIngredient8")
    val ingredient8: String? = null,
    @SerializedName("strIngredient9")
    val ingredient9: String? = null,
    @SerializedName("strIngredient10")
    val ingredient10: String? = null,
    @SerializedName("strIngredient11")
    val ingredient11: String? = null,
    @SerializedName("strIngredient12")
    val ingredient12: String? = null,
    @SerializedName("strIngredient13")
    val ingredient13: String? = null,
    @SerializedName("strIngredient14")
    val ingredient14: String? = null,
    @SerializedName("strIngredient15")
    val ingredient15: String? = null,
    @SerializedName("strMeasure1")
    val measure1: String? = null,
    @SerializedName("strMeasure2")
    val measure2: String? = null,
    @SerializedName("strMeasure3")
    val measure3: String? = null,
    @SerializedName("strMeasure4")
    val measure4: String? = null,
    @SerializedName("strMeasure5")
    val measure5: String? = null,
    @SerializedName("strMeasure6")
    val measure6: String? = null,
    @SerializedName("strMeasure7")
    val measure7: String? = null,
    @SerializedName("strMeasure8")
    val measure8: String? = null,
    @SerializedName("strMeasure9")
    val measure9: String? = null,
    @SerializedName("strMeasure10")
    val measure10: String? = null,
    @SerializedName("strMeasure11")
    val measure11: String? = null,
    @SerializedName("strMeasure12")
    val measure12: String? = null,
    @SerializedName("strMeasure13")
    val measure13: String? = null,
    @SerializedName("strMeasure14")
    val measure14: String? = null,
    @SerializedName("strMeasure15")
    val measure15: String? = null,
) : Parcelable

data class ListCocktail(
    @SerializedName("drinks")
    val listCocktail: List<Cocktail>
)

data class ListIngredients(
    val ingredient: String? = "",
    val measure: String? = ""
)

@Entity(tableName = "table_cocktail")
data class CocktailEntity(
    @PrimaryKey
    val id: String = "",
    val name: String = "",
    val alcoholic: String = "",
    val video: String? = null,
    val glass: String = "",
    val instructions: String = "",
    val image: String = "",
    val ingredient1: String? = null,
    val ingredient2: String? = null,
    val ingredient3: String? = null,
    val ingredient4: String? = null,
    val ingredient5: String? = null,
    val ingredient6: String? = null,
    val ingredient7: String? = null,
    val ingredient8: String? = null,
    val ingredient9: String? = null,
    val ingredient10: String? = null,
    val ingredient11: String? = null,
    val ingredient12: String? = null,
    val ingredient13: String? = null,
    val ingredient14: String? = null,
    val ingredient15: String? = null,
    val measure1: String? = null,
    val measure2: String? = null,
    val measure3: String? = null,
    val measure4: String? = null,
    val measure5: String? = null,
    val measure6: String? = null,
    val measure7: String? = null,
    val measure8: String? = null,
    val measure9: String? = null,
    val measure10: String? = null,
    val measure11: String? = null,
    val measure12: String? = null,
    val measure13: String? = null,
    val measure14: String? = null,
    val measure15: String? = null,
)
