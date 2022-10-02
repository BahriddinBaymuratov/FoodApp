package com.example.foodapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodapp.R
import com.example.foodapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this,AddFoodActivity::class.java)
            startActivity(intent)
        }
        binding.btnMenu.setOnClickListener {
            val intent = Intent(this,AllFoodActivity::class.java)
            startActivity(intent)
        }
    }
}