package com.bunkware.bunkyrecipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.bunkware.bunkyrecipe.models.RecipeModel
import com.bunkware.bunkyrecipe.utils.primaryBackgroundColor


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //var recipeModal = RecipeModel()
        //recipeModal.createRecipeList()

        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme{
                Surface(modifier = Modifier.fillMaxSize(),
                color = primaryBackgroundColor) {
                    RecipeBookApp()
                }
            }
        }
    }
}



