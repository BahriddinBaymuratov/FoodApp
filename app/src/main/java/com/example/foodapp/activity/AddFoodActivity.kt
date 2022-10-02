package com.example.foodapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.foodapp.activity.adapter.MyDataBase
import com.example.foodapp.activity.model.Food
import com.example.foodapp.databinding.ActivityAddFoodBinding

class AddFoodActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddFoodBinding.inflate(layoutInflater) }
    private lateinit var myDataBase: MyDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.title = "Taom Qo'shish"

        myDataBase = MyDataBase(this)

        binding.btnSave.setOnClickListener {
            val name = binding.editName.text.toString().trim()
            val product = binding.editProduct.text.toString().trim()
            val preparation = binding.editText.text.toString().trim()
            if (name.isBlank() && preparation.isBlank()) {
                Toast.makeText(this, "Enter food!!", Toast.LENGTH_SHORT).show()
            } else {
                myDataBase.addFood(Food(name, product, preparation))
                Toast.makeText(this, "Succesfully saved food!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}




















