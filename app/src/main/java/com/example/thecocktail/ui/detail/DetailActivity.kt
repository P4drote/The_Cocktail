package com.example.thecocktail.ui.detail

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.thecocktail.databinding.ActivityDetailBinding
import com.example.thecocktail.model.Cocktail
import com.example.thecocktail.ui.adapters.IngredientsAdapter
import com.example.thecocktail.util.Utils
import com.example.thecocktail.util.setUpToolbar
import com.google.android.material.snackbar.Snackbar
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.TransformationLayout
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var cocktail: Cocktail
    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cocktail = intent.getParcelableExtra("cocktail")!!

        setUpToolbar(binding.toolbarDetail, "Details of Cocktail", true)
        updateView()
        setupButtonYouTube()
        setupRecyclerView()
        setupListener()
        setupObserver()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateView() {
        viewModel.getIsFavorite(cocktail.id)
        with(binding) {
            Glide.with(this@DetailActivity).load(cocktail.image).centerCrop().into(imageCocktail)
            name.text = cocktail.name
            alcoholic.text = cocktail.alcoholic
            glass.text = cocktail.glass
            instructions.text = cocktail.instructions
        }
        binding.scrollView2.fullScroll(View.FOCUS_UP)
    }

    fun toCamelCase(str: String): String =
        str.split("-", "_").mapIndexed { i, s -> if (i == 0) s else s.capitalize(Locale.ROOT) }.joinToString("")

    private fun setupObserver() {
        viewModel.isFavorite.observe(this, ::setupButtonFavorite)
    }

    private fun setupButtonFavorite(isFavorite: Boolean) {
        if (isFavorite) {
            val icon =
                ContextCompat.getDrawable(this, android.R.drawable.btn_star_big_on)
            binding.buttonAddFavorites.setImageDrawable(icon)
        } else {
            val icon =
                ContextCompat.getDrawable(this, android.R.drawable.btn_star_big_off)
            binding.buttonAddFavorites.setImageDrawable(icon)
        }
    }

    private fun setupListener() {
        with(binding) {
            buttonSeeInYouTube.setOnClickListener {
                showVideoInYouTube()
            }
            buttonAddFavorites.setOnClickListener {
                if (viewModel.isFavorite.value == true) {
                    deleteFavoriteCocktail()
                } else {
                    saveFavoriteCocktail()
                }
            }
        }
    }

    private fun saveFavoriteCocktail() {
        viewModel.saveFavoriteCocktail(Utils.convertCocktailToCocktailEntity(cocktail))
        Snackbar.make(binding.root, "Added cocktail to favorites", Snackbar.LENGTH_LONG).show()
    }

    private fun deleteFavoriteCocktail() {
        viewModel.deleteFavoriteCocktail(Utils.convertCocktailToCocktailEntity(cocktail))
        Snackbar.make(binding.root, "Deleted cocktail of favorites", Snackbar.LENGTH_LONG).show()
    }

    private fun showVideoInYouTube() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(cocktail.video)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        val listIngredients = Utils.convertIngredientsToList(cocktail)
        binding.recyclerViewIngredients.adapter = IngredientsAdapter(listIngredients)
    }

    private fun setupButtonYouTube() {
        if (cocktail.video == null) {
            binding.buttonSeeInYouTube.visibility = View.GONE
        } else {
            binding.buttonSeeInYouTube.visibility = View.VISIBLE
        }
    }

    companion object {
        private const val cocktailExtraName = "cocktail"
        fun startActivity(
            context: Context,
            transformationLayout: TransformationLayout,
            cocktail: Cocktail
        ) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(cocktailExtraName, cocktail)
            TransformationCompat.startActivity(transformationLayout, intent)
        }
    }
}