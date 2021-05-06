package com.example.thecocktail.ui.favorites

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.thecocktail.databinding.ActivityFavoritesBinding
import com.example.thecocktail.model.Cocktail
import com.example.thecocktail.model.CocktailEntity
import com.example.thecocktail.ui.adapters.CocktailAdapter
import com.example.thecocktail.ui.detail.DetailActivity
import com.example.thecocktail.util.Utils
import com.example.thecocktail.util.setUpToolbar
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.TransformationLayout
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavoritesActivity : AppCompatActivity(), CocktailAdapter.OnCocktailClickListener {

    private lateinit var binding: ActivityFavoritesBinding
    private val viewModel by viewModels<FavoritesViewModel>()
    private lateinit var listOfCocktail: List<Cocktail>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
//        setUpToolbar(binding.toolbar, withBackArrow = true)
        setContentView(binding.root)
        this.actionBar?.setDisplayHomeAsUpEnabled(true)

        setUpToolbar(binding.toolbarFavorites, "Cocktails Favorites", true)
        setupObserver()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupObserver() {
        viewModel.listOfFavoritesCocktail.observe(this, ::render)
    }

    private fun render(listOfFavoritesCocktailFromDb: List<CocktailEntity>) {
        listOfCocktail = Utils.convertListCocktailEntityToListCocktail(listOfFavoritesCocktailFromDb)
        binding.recyclerViewFavorites.adapter =
            CocktailAdapter(listOfCocktail, this)
    }

    override fun onCocktailClick(
        cocktail: Cocktail,
        transformationLayoutListCocktail: TransformationLayout
    ) {
        DetailActivity.startActivity(this, transformationLayoutListCocktail, cocktail)
    }

    companion object {
        fun startActivity(context: Context, transformationLayout: TransformationLayout) {
            val intent = Intent(context, FavoritesActivity::class.java)
            TransformationCompat.startActivity(transformationLayout, intent)
        }
    }
}