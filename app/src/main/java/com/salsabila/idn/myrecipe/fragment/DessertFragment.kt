package com.salsabila.idn.myrecipe.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.salsabila.idn.myrecipe.R
import com.salsabila.idn.myrecipe.adapter.FoodAdapter
import com.salsabila.idn.myrecipe.databinding.FragmentDessertBinding
import com.salsabila.idn.myrecipe.model.DataRecipes
import com.salsabila.idn.myrecipe.model.Recipes

class DessertFragment : Fragment() {
    private lateinit var dessertBinding: FragmentDessertBinding
    private val list : ArrayList<Recipes> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        dessertBinding = FragmentDessertBinding.inflate(inflater,container, false)
        return dessertBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.addAll(DataRecipes.dataDessert)
        dessertBinding.rvDessert.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            val foodAdapter =  FoodAdapter(list)
            adapter = foodAdapter
        }
    }
}