package com.example.foodapp.activity.adapter

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.foodapp.activity.model.Food
import com.example.foodapp.activity.util.Constants
import com.example.foodapp.activity.util.Service

class MyDataBase(context: Context):
        SQLiteOpenHelper(context,Constants.MY_DB_NAME,null,Constants.VERSION),Service{

        override fun onCreate(db: SQLiteDatabase?) {
                val query =
                        "CREATE TABLE ${Constants.TABLE_NAME} (${Constants.ID} INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,${Constants.NAME} TEXT NOT NULL, ${Constants.PRODUCT} TEXT NOT NULL,${Constants.PREPARATION} TEXT NOT NULL)"
                db?.execSQL(query)
        }

        override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
                db?.execSQL("DROP TABLE IF EXISTS ${Constants.TABLE_NAME}")
                onCreate(db)
        }

        override fun addFood(food: Food) {
                val dataBase = this.writableDatabase
                val contentValues = ContentValues()
                contentValues.put(Constants.NAME, food.name)
                contentValues.put(Constants.PRODUCT, food.product)
                contentValues.put(Constants.PREPARATION, food.preparation)
                dataBase.insert(
                        Constants.TABLE_NAME,
                        null,
                        contentValues
                )
                dataBase.close()
        }

        override fun allFoods(): MutableList<Food> {
                val foodList = ArrayList<Food>()
                val query = "SELECT * FROM ${Constants.TABLE_NAME}"
                val dataBase = this.readableDatabase
                val cursor = dataBase.rawQuery(query, null)
                if (cursor.moveToFirst()){
                        do {
                            val food = Food(cursor.getString(1), cursor.getString(2),cursor.getString(3))
                                foodList.add(food)
                        } while (cursor.moveToNext())
                }
                return foodList
        }
}
