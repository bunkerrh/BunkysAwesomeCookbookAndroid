package com.bunkware.bunkyrecipe.recipe.models


import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("foodPic")
    val foodPic: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("ingredients")
    val ingredients: List<Ingredient>,
    @SerializedName("instructions")
    val instructions: List<Instruction>,
    @SerializedName("isVegan")
    val isVegan: Boolean,
    @SerializedName("recipeName")
    val recipeName: String,
    @SerializedName("timeHours")
    val timeHours: Int,
    @SerializedName("timeMinutes")
    val timeMinutes: Int,
    @SerializedName("timeSeconds")
    val timeSeconds: Int
)