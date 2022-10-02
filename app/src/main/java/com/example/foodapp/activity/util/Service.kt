package com.example.foodapp.activity.util

import com.example.foodapp.activity.model.Food

interface Service {
    fun addFood(food: Food)
    fun allFoods() : MutableList<Food>
}