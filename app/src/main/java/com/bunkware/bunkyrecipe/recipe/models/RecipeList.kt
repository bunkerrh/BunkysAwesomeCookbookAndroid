package com.bunkware.bunkyrecipe.recipe.models


import com.google.gson.annotations.SerializedName

data class RecipeList(
    @SerializedName("recipeList")
    val recipeList: List<Recipe>
)