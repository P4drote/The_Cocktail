package com.example.thecocktail.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thecocktail.databinding.ItemIngredientsBinding
import com.example.thecocktail.model.ListIngredients

class IngredientsAdapter(private var listIngredients: List<ListIngredients>) :
    RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder>() {

    private lateinit var binding: ItemIngredientsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        binding = ItemIngredientsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IngredientsViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        val cocktail = listIngredients[position]
        holder.bind(cocktail)
    }

    override fun getItemCount(): Int = listIngredients.size

    inner class IngredientsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(cocktail: ListIngredients) {
            with(binding) {
                ingredient.text = cocktail.ingredient
                measure.text = cocktail.measure
            }
        }
    }
}