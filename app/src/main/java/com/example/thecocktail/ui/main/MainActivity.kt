package com.example.thecocktail.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.example.thecocktail.databinding.ActivityMainBinding
import com.example.thecocktail.model.Cocktail
import com.example.thecocktail.ui.adapters.CocktailAdapter
import com.example.thecocktail.ui.detail.DetailActivity
import com.example.thecocktail.ui.favorites.FavoritesActivity
import com.example.thecocktail.util.Resource
import com.example.thecocktail.util.Utils
import com.example.thecocktail.util.setUpToolbar
import com.mancj.materialsearchbar.MaterialSearchBar
import com.skydoves.transformationlayout.TransformationLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CocktailAdapter.OnCocktailClickListener {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Cocktail App"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpToolbar(binding.toolbar, "Cocktail App")
        setupObserver()
        setupSearch()
        setupListener()
    }

    private fun setupListener() {
        binding.goToFavorites.setOnClickListener {
            FavoritesActivity.startActivity(this, binding.transformationLayoutFromMainToFavorites)
        }
    }

    private fun setupSearch() {
        binding.searchBar.setOnSearchActionListener(object :
            MaterialSearchBar.OnSearchActionListener {
            override fun onSearchStateChanged(enabled: Boolean) {
                //NOT YET IMPLEMENT
            }

            override fun onSearchConfirmed(text: CharSequence?) {
                viewModel.cocktailToSearch(text.toString())
                Utils.closeKeyboard(this@MainActivity, binding.root)
            }

            override fun onButtonClicked(buttonCode: Int) {
                //NOT YET IMPLEMENT
            }

        })
    }

    private fun setupObserver() {
        viewModel.getCocktail.observe(this as LifecycleOwner, this::render)
    }

    private fun render(result: Resource<List<Cocktail>>?) {
        when (result) {
            is Resource.Loading -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            is Resource.Success -> {
                binding.progressBar.visibility = View.GONE
                binding.recyclerViewMain.adapter = CocktailAdapter(result.data, this)
            }
            is Resource.Failure -> {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(this, "No me conecto: ${result.exception}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCocktailClick(
        cocktail: Cocktail,
        transformationLayoutListCocktail: TransformationLayout
    ) {
        DetailActivity.startActivity(this, transformationLayoutListCocktail, cocktail)
    }
}