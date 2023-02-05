package com.bunkware.bunkyrecipe.mocks

import com.bunkware.bunkyrecipe.recipe.models.*


var ingredient: Ingredient = Ingredient(
    "1",
    "Teasponn",
    "Garlic"
)
var onion: Ingredient = Ingredient(
    "",
    "",
    "Yellow Onion"
)
var groundBeef: Ingredient = Ingredient(
    "3",
    "Pound",
    "Ground Beef"
)
var milk: Ingredient = Ingredient(
    "4",
    "Cups",
    "Whole Milk"
)
var sourCream: Ingredient = Ingredient(
    "1/2",
    "Cups",
    "Sour Cream"
)
var sugar: Ingredient = Ingredient(
    "1",
    "Cup",
    "White Sugar"
)


var instruction: Instruction = Instruction(
    "On medium high heat brown ground beef until cooked throughly",
    1,

)
var instruction2: Instruction = Instruction(
    "Dice Two Yellow Onions. Add onions to pan and cook until translucent. Bring to boil and allow to simmer",
    2

)
var instruction3: Instruction = Instruction(
    "Chop Mushroom carrots and milk. Once pan in simmering add Mushroom carrots and milk and cook until soft",
    3
)
var instruction4: Instruction = Instruction(
    "This is some test text to see what happens when we have a lot of text. The next one is just going to be lorem ipsum because why the hell not. I think it has a lot of letters",
    4
)
var instruction5: Instruction = Instruction(
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus vulputate justo nec elit consectetur, ornare facilisis velit condimentum. Duis euismod dolor ante, id gravida augue maximus id. Nam vulputate nulla et ornare suscipit. Praesent vel hendrerit sapien, sit amet dictum sapien. Praesent lobortis, mi at tristique lobortis, diam turpis feugiat elit, eget vehicula est justo non augue. Quisque maximus nisi sit amet ipsum bibendum tempor. Vivamus vulputate lacus egestas mollis pharetra. Morbi vel sem enim. Quisque sed porta sapien. Nullam leo arcu, dapibus vitae tempus quis, posuere vel arcu. Quisque rutrum tempus dui, eget euismod arcu sagittis et. Integer et elementum neque, vitae consequat magna. Quisque facilisis tellus eget ligula accumsan laoreet. Fusce fermentum nisi vel augue consectetur posuere. Morbi efficitur scelerisque viverra. ",
    5
)

val ingredientArray = arrayListOf<Ingredient>(ingredient, onion, groundBeef, milk, sourCream, sugar)
val instructionArray =
    arrayListOf<Instruction>(instruction, instruction2, instruction3, instruction4, instruction5)


var recipeMock1: Recipe = Recipe(
    rawLasagna,
"1",
    ingredientArray,
    instructionArray,
    false,
    "Bunky strog1",
    1,
    45,
    0,


)
var recipeMock2: Recipe = Recipe(
    rawStrog,
    "1",
    ingredientArray,
    instructionArray,
    false,
    "beef strog2",
    1,
    45,
    0,


)
var recipeMock3: Recipe = Recipe(
    rawLasagna,
    "1",
    ingredientArray,
    instructionArray,
    false,
    "Bunky strog1",
    1,
    45,
    0,
)
var recipeMock4: Recipe = Recipe(
    rawStrog,
    "1",
    ingredientArray,
    instructionArray,
    false,
    "beef strog2",
    1,
    45,
    0,

    )

var recipeMock5: Recipe = Recipe(
    rawLasagna,
    "1",
    ingredientArray,
    instructionArray,
    false,
    "Bunky strog1",
    1,
    45,
    0,
)
var recipeMock6: Recipe = Recipe(
    rawStrog,
    "1",
    ingredientArray,
    instructionArray,
    false,
    "beef strog2",
    1,
    45,
    0,

    )

var recipeMock7: Recipe = Recipe(
    rawLasagna,
    "1",
    ingredientArray,
    instructionArray,
    false,
    "Bunky strog1",
    1,
    45,
    0,
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

var mockRecipeList = RecipeList(recipeArray)