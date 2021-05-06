package com.example.thecocktail.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thecocktail.databinding.ItemCocktailBinding
import com.example.thecocktail.model.Cocktail

class MyAdapter(
    private val listOfCocktail: List<Cocktail>,
    private val onClickCocktailListener: OnClickCocktailListener
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var binding: ItemCocktailBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemCocktailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listOfCocktail[position])
    }

    override fun getItemCount(): Int = listOfCocktail.size

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(cocktail: Cocktail) {
            binding.nameCocktail.text = cocktail.name
            binding.alcoholic.text = cocktail.alcoholic
            Glide.with(binding.root).load(cocktail.image).centerCrop().into(binding.imageCocktail)
            setupClick(cocktail)
        }

        private fun setupClick(cocktail: Cocktail) {
            itemView.setOnClickListener { onClickCocktailListener.onClickCocktail(cocktail) }
        }
    }

    interface OnClickCocktailListener {
        fun onClickCocktail(cocktail: Cocktail)
    }
}