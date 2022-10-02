package com.example.foodapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodapp.R
import com.example.foodapp.activity.adapter.FoodAdapter
import com.example.foodapp.activity.adapter.MyDataBase
import com.example.foodapp.activity.model.Food
import com.example.foodapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private val binding by lazy { ActivityResultBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val food = intent.getSerializableExtra("food") as Food
        binding.textName.text = food.name
        binding.textProduct.text  = food.product
        binding.textViewText.text = food.preparation
    }
}