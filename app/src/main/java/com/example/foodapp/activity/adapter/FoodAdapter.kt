package com.example.foodapp.activity.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.activity.ResultActivity
import com.example.foodapp.activity.model.Food
import com.example.foodapp.databinding.FoodLayoutBinding

class FoodAdapter: RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    var foodList: MutableList<Food> = mutableListOf()
    lateinit var onItemClicked: (Food)-> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(
            FoodLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        )
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodList[position])
    }

    override fun getItemCount(): Int = foodList.size

    inner class FoodViewHolder(private val binding: FoodLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(food: Food){
            binding.textView.text = food.name
            itemView.setOnClickListener {
                onItemClicked(food)
            }
        }
    }
}