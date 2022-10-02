package com.example.foodapp.activity.model

import java.io.Serializable


class Food: Serializable {
    var id : Int? = null
    var name: String? = null
    var product: String? = null
    var preparation:String? = null



    constructor(id: Int?, name: String?, product: String?, preparation: String?) {
        this.id = id
        this.name = name
        this.product = product
        this.preparation = preparation
    }

    constructor(name: String, product: String?, preparation: String?) {
        this.name = name
        this.product = product
        this.preparation = preparation
    }

    override fun toString(): String {
        return "$name $product $preparation"
    }
}