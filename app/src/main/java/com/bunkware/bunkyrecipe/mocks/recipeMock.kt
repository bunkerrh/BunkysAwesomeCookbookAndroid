package com.bunkware.bunkyrecipe.mocks

import com.bunkware.bunkyrecipe.R
import com.bunkware.bunkyrecipe.models.Ingredient
import com.bunkware.bunkyrecipe.models.Instruction
import com.bunkware.bunkyrecipe.models.Recipe

var ingredient: Ingredient = Ingredient(
    1,
    "Garlic",
    "1",
    "Teaspoon",
    1
)
var onion: Ingredient = Ingredient(
    2,
    "Yellow Onion",
    "2",
    "",
    1
)
var groundBeef: Ingredient = Ingredient(
    3,
    "Ground Beef",
    "1",
    "pound",
    1
)
var milk: Ingredient = Ingredient(
    4,
    "Whole Milk",
    "1",
    "Gallon",
    1
)
var sourCream: Ingredient = Ingredient(
    5,
    "Sour Cream",
    "1/2",
    "Cup",
    1
)
var sugar: Ingredient = Ingredient(
    6,
    "White Sugar",
    "1",
    "Cup",
    1
)


var instruction: Instruction = Instruction(
    1,
    "On medium high heat brown ground beef until cooked throughly",
    1
)
var instruction2: Instruction = Instruction(
    2,
    "Dice Two Yellow Onions. Add onions to pan and cook until translucent. Bring to boil and allow to simmer",
    1
)
var instruction3: Instruction = Instruction(
    3,
    "Chop Mushroom carrots and milk. Once pan in simmering add Mushroom carrots and milk and cook until soft",
    1
)
var instruction4: Instruction = Instruction(
    4,
    "This is some test text to see what happens when we have a lot of text. The next one is just going to be lorem ipsum because why the hell not. I think it has a lot of letters",
    1
)
var instruction5: Instruction = Instruction(
    5,
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus vulputate justo nec elit consectetur, ornare facilisis velit condimentum. Duis euismod dolor ante, id gravida augue maximus id. Nam vulputate nulla et ornare suscipit. Praesent vel hendrerit sapien, sit amet dictum sapien. Praesent lobortis, mi at tristique lobortis, diam turpis feugiat elit, eget vehicula est justo non augue. Quisque maximus nisi sit amet ipsum bibendum tempor. Vivamus vulputate lacus egestas mollis pharetra. Morbi vel sem enim. Quisque sed porta sapien. Nullam leo arcu, dapibus vitae tempus quis, posuere vel arcu. Quisque rutrum tempus dui, eget euismod arcu sagittis et. Integer et elementum neque, vitae consequat magna. Quisque facilisis tellus eget ligula accumsan laoreet. Fusce fermentum nisi vel augue consectetur posuere. Morbi efficitur scelerisque viverra. ",
    1
)

val ingredientArray = arrayListOf<Ingredient>(ingredient, onion, groundBeef, milk, sourCream, sugar)
val instructionArray = arrayListOf<Instruction>(instruction, instruction2, instruction3, instruction4, instruction5)

var recipeMock1: Recipe = Recipe(
    1,
    "Bunky strog1",
    false,
    1,
    45,
    0,
    ingredientArray,
    instructionArray,
    R.drawable.beef_stroganoff_2022_ig_3
)
var recipeMock2: Recipe = Recipe(
    1,
    "beef strog2",
    false,
    1,
    45,
    0,
    ingredientArray,
    instructionArray,
    R.drawable.beefs
)
var recipeMock3: Recipe = Recipe(
    1,
    "Bunk strog3",
    false,
    1,
    45,
    0,
    ingredientArray,
    instructionArray,
    R.drawable.beef_stroganoff_2022_ig_3
)
var recipeMock4: Recipe = Recipe(
    1,
    "beef strog4",
    false,
    1,
    45,
    0,
    ingredientArray,
    instructionArray,
    R.drawable.beefs
)

var recipeMock5: Recipe = Recipe(
    1,
    "Bunky strog5",
    false,
    1,
    45,
    0,
    ingredientArray,
    instructionArray,
    R.drawable.beef_stroganoff_2022_ig_3
)
var recipeMock6: Recipe = Recipe(
    1,
    "beef strog6",
    false,
    1,
    45,
    0,
    ingredientArray,
    instructionArray,
    R.drawable.beefs
)

var recipeMock7: Recipe = Recipe(
    1,
    "beef strog7",
    false,
    1,
    45,
    0,
    ingredientArray,
    instructionArray,
    R.drawable.beef_stroganoff_2022_ig_3
)


var recipeArray = arrayListOf<Recipe>(
    recipeMock1,
    recipeMock2,
    recipeMock3,
    recipeMock4,
    recipeMock5,
    recipeMock6,
    recipeMock7
)