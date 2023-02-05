package com.bunkware.bunkyrecipe.api

import com.bunkware.bunkyrecipe.recipe.models.RecipeList
import javax.inject.Inject

class RecipeRepo @Inject constructor(
    private val recipeApi: RecipeApi
    ) {
    suspend fun getAllRecipes(): RecipeList {
        return recipeApi.getRecipes()
    }
}