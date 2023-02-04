package com.bunkware.bunkyrecipe.ui.recipe

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.bunkware.bunkyrecipe.utils.*
import androidx.navigation.compose.rememberNavController
import com.bunkware.bunkyrecipe.R
import com.bunkware.bunkyrecipe.ui.RecipeGridScreen
import com.bunkware.bunkyrecipe.views.recipeGridView.RecipeView

enum class RecipeScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    RecipePage(title = R.string.recipe_page)
}


@Preview
@Composable
fun RecipeBookTest() {
    RecipeBookApp()
}



@Composable
fun RecipeBookApp(
    navController: NavHostController = rememberNavController()
) {
    Log.d("GetRecipe", "Still in Recipe Screen About to make hte call")

    val recipeViewModel = viewModel(modelClass = RecipeViewModel::class.java)

    var editMode by remember { mutableStateOf(false) }
    Scaffold(
        backgroundColor = primaryBackgroundColor,
        topBar = {
            val title = "Edit"
            Column {
                Row(Modifier.padding(10.dp)) {
                    NiceButton(title = title) {
                        editMode = !editMode
                    }
                }
            }
        },
        bottomBar = {
        }) { innerPadding ->
        NavHost(
            navController,
            RecipeScreen.Start.name
        ) {
            composable(route = RecipeScreen.Start.name) {
                RecipeGridScreen(
                    onGridButtonClick = {
                        navController.navigate(RecipeScreen.RecipePage.name)
                    }
                )
            }
            composable(route = RecipeScreen.RecipePage.name) {
                val state = recipeViewModel.recipeState.collectAsState()
                RecipeView(state.value)
            }
        }
    }
}
