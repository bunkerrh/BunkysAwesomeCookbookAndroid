package com.bunkware.bunkyrecipe.models

import com.bunkware.bunkyrecipe.mocks.recipeMock1
import kotlinx.serialization.Serializable


data class RecipeUiState(
    val recipe: Recipe = recipeMock1
)


@Serializable
data class Recipe(
    val id: Int,
    val name: String,
    val isVegan: Boolean,
    val timeHours: Int,
    val timeMinutes: Int,
    val timeSeconds: Int,
    val ingredients: ArrayList<Ingredient>,
    val instructions: ArrayList<Instruction>,
    val image: Int
)


@Serializable
data class Ingredient(
    val id: Int,
    val name: String,
    val measurementAmount: String,
    val measurement: String,
    val recipeId: Int
)

@Serializable
data class Instruction(
    val stepNo: Int,
    val stepInstruction: String,
    val recipeId: Int
)