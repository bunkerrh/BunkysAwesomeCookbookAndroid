package com.bunkware.bunkyrecipe.models

import androidx.lifecycle.ViewModel
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
}