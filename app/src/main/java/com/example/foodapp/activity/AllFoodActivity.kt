package com.example.foodapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.R
import com.example.foodapp.activity.adapter.FoodAdapter
import com.example.foodapp.activity.adapter.MyDataBase
import com.example.foodapp.activity.model.Food
import com.example.foodapp.databinding.ActivityAllFoodBinding

class AllFoodActivity : AppCompatActivity() {
    private lateinit var myDataBase: MyDataBase
    private lateinit var foodAdapter: FoodAdapter
    private val binding by lazy { ActivityAllFoodBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.title = "Barcha Taomlar"

        myDataBase = MyDataBase(this)
        foodAdapter = FoodAdapter()
        foodAdapter.foodList = myDataBase.allFoods()

        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@AllFoodActivity)
            adapter = foodAdapter
        }

        foodAdapter.onItemClicked = {
            val bundle = bundleOf("food" to it)
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }

    }
}