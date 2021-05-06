package com.example.thecocktail.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thecocktail.databinding.ItemCocktailBinding
import com.example.thecocktail.model.Cocktail
import com.skydoves.transformationlayout.TransformationLayout

class CocktailAdapter(
    private val listCocktail: List<Cocktail>,
    private val onCocktailClickListener: OnCocktailClickListener
) :
    RecyclerView.Adapter<CocktailAdapter.CocktailViewHolder>() {

    private lateinit var binding: ItemCocktailBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        binding = ItemCocktailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CocktailViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        val cocktail = listCocktail[position]
        holder.bind(cocktail)
    }

    override fun getItemCount(): Int = listCocktail.size

    inner class CocktailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(cocktail: Cocktail) {
            Glide.with(binding.root).load(cocktail.image).centerCrop().into(binding.imageCocktail)
            binding.nameCocktail.text = cocktail.name
            binding.alcoholic.text = cocktail.alcoholic
            setupClick(cocktail, binding.transformationLayoutItemCocktail)
        }

        private fun setupClick(cocktail: Cocktail, transformationLayoutListCocktail: TransformationLayout) {
            itemView.setOnClickListener { onCocktailClickListener.onCocktailClick(cocktail, transformationLayoutListCocktail) }
        }
    }

    interface OnCocktailClickListener {
        fun onCocktailClick(cocktail: Cocktail, transformationLayoutListCocktail: TransformationLayout)
    }
}


