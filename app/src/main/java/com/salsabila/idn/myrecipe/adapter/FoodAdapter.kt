package com.salsabila.idn.myrecipe.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.salsabila.idn.myrecipe.DetailActivity
import com.salsabila.idn.myrecipe.databinding.ItemFoodBinding
import com.salsabila.idn.myrecipe.model.Recipes

class FoodAdapter(private val listFood: ArrayList<Recipes>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    inner class FoodViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodAdapter.FoodViewHolder, position: Int) {
        with(holder) {
            with(listFood[position]) {
                Glide.with(holder.itemView.context).load(pictures).into(binding.ivItemRecipe)
                binding.tvItemNameRecipe.text = name
                binding.tvItemMenu.text = category
                binding.tvNumberRecipe.text = number
                val mContext = holder.itemView.context
                holder.itemView.setOnClickListener {
                    val dataSend = Recipes(
                        name = listFood[position].name,
                        category = listFood[position].category,
                        description = listFood[position].description,
                        ingredients = listFood[position].ingredients,
                        instructions = listFood[position].instructions,
                        pictures = listFood[position].pictures,
                        number = listFood[position].number,
                        calories = listFood[position].calories,
                        carbo = listFood[position].carbo,
                        protein = listFood[position].protein
                    )
                    val intentToDetail = Intent(mContext,DetailActivity::class.java)
                    intentToDetail.putExtra(DetailActivity.RECIPE_DATA, dataSend)
                    mContext.startActivity(intentToDetail)
                }
            }
        }
    }

    override fun getItemCount(): Int = listFood.size
}