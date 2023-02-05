package com.bunkware.bunkyrecipe.api

import com.bunkware.bunkyrecipe.recipe.models.RecipeList
import retrofit2.http.GET

interface RecipeApi {
    @GET("recipe/getRecipes")
    suspend fun getRecipes(): RecipeList
}

