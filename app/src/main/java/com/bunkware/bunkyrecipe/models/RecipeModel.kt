package com.bunkware.bunkyrecipe.models

import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecipeModel: ViewModel() {

    /**
     * Recipe state for this order
     */
    private val _uiState = MutableStateFlow(RecipeUiState())
    val uiState: StateFlow<RecipeUiState> = _uiState.asStateFlow()


    fun setRecipe(newRecipe: Recipe) {
        _uiState.update { currentState ->
            currentState.copy(
                recipe = newRecipe,
            )
        }
    }
//    fun createRecipeList() {
//        val jsonObject = JsonObjectRequest(
//            "localhost:9091/recipe/getRecipes/1",
//            Request.Method.GET,
//            null
//        ){
//
//        }
//    }
}