package com.bunkware.bunkyrecipe.ui.recipe

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bunkware.bunkyrecipe.api.RecipeRepo
import com.bunkware.bunkyrecipe.mocks.recipeMock1
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.bunkware.bunkyrecipe.recipe.models.*


@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeRepo: RecipeRepo
) : ViewModel() {
    private val _state = MutableStateFlow(emptyList<Recipe>())
    val state: StateFlow<List<Recipe>>
        get() = _state

    private var _recipeState = MutableStateFlow(recipeMock1)
    val recipeState: StateFlow<Recipe>
        get() = _recipeState

    fun setRecipe(recipe: Recipe) {
        _recipeState.value = recipe
    }

    init {
        viewModelScope.launch {
            try {
                val recipeList = recipeRepo.getAllRecipes()
                _state.value = recipeList.recipeList
            } catch (e: Exception) {
                Log.d("Server Call", "Error getting recipe list from server")
            }

        }
    }
}
