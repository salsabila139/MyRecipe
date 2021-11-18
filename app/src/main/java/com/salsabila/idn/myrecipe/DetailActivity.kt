package com.salsabila.idn.myrecipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.salsabila.idn.myrecipe.databinding.ActivityDetailBinding
import com.salsabila.idn.myrecipe.model.Recipes

class DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        showData()
    }

    private fun showData() {
        val getData = intent.getParcelableExtra<Recipes>(RECIPE_DATA) as Recipes
        Glide.with(this).load(getData.pictures).into(detailBinding.ivDetail)
        detailBinding.tvNameDetail.text = getData.name
        detailBinding.tvDescriptionDetail.text = getData.description
        detailBinding.tvIngredients.text = getData.ingredients
        detailBinding.tvCalories.text = getData.calories
        detailBinding.tvCarbo.text = getData.carbo
        detailBinding.tvInstruction.text = getData.instructions
        detailBinding.tvProtein.text = getData.protein
        detailBinding.tvValueCalories.text = getData.calories
        detailBinding.tvValueCarbo.text = getData.carbo
        detailBinding.tvValueProtein.text = getData.protein
        detailBinding.tvLabelInstruction.text = getData.instructions
        detailBinding.tvIngredientsLabel.text = getData.ingredients
        detailBinding.tvRecipelable.text = getData.ingredients
    }

    companion object {
        const val RECIPE_DATA = "recipe_data"
    }
}