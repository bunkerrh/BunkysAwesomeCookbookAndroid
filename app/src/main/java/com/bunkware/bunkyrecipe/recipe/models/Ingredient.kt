package com.bunkware.bunkyrecipe.recipe.models


import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("measurement")
    val measurement: String,
    @SerializedName("measurementAmount")
    val measurementAmount: String,
    @SerializedName("name")
    val name: String
)