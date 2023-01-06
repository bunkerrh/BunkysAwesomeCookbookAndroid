package com.bunkware.bunkyrecipe.views.recipeGridView

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bunkware.bunkyrecipe.mocks.recipeMock1
import com.bunkware.bunkyrecipe.models.Ingredient
import com.bunkware.bunkyrecipe.models.Instruction
import com.bunkware.bunkyrecipe.models.Recipe
import com.bunkware.bunkyrecipe.utils.*

// so what we want to do is set up a composable where we are creating text rows in this order Name, Cook Time, Ingredients List, Instruction. Somewhere we should probably add a picture

@Preview
@Composable
fun RecipeViewTest() {
    RecipeView(recipe = recipeMock1)
}
@Preview
@Composable
fun InstructionTest() {
    InstructionColumn(instructions = recipeMock1.instructions)
}
@Preview
@Composable
fun IngredientTest() {
    IngredientColumn(ingredients = recipeMock1.ingredients)
}

@Composable
fun RecipeView(recipe: Recipe) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(primaryColor)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            item {
                Text(
                    recipe.name,
                    style = MaterialTheme.typography.subtitle1,
                    color = primaryTextColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp
                )
                Spacer(Modifier.width(normalRadius))
                Text(
                    "Cook Time: ${recipe.timeHours}:${recipe.timeMinutes}:${recipe.timeSeconds}",
                    style = MaterialTheme.typography.subtitle1,
                    color = primaryTextColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                )
                Spacer(Modifier.width(20.dp))
                IngredientColumn(ingredients = recipe.ingredients)
                Spacer(Modifier.width(20.dp))
                InstructionColumn(instructions = recipe.instructions)
            }
        }

}



@Composable
fun InstructionColumn(instructions: ArrayList<Instruction>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(primaryColor)
            .padding(top = 50.dp, bottom = 50.dp)
            .fillMaxWidth()
            .border(width = 5.dp, color = primaryBackgroundColor)
    )
    {
        instructions.forEach {
            Text(
                "" + it.stepNo + ". " + it.stepInstruction,
                style = MaterialTheme.typography.subtitle1,
                color = primaryTextColor,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)

            )
            Spacer(Modifier.width(50.dp))

        }
    }


}

@Composable
fun IngredientColumn(ingredients: ArrayList<Ingredient>) {
    var bullet = "\u2022"
    var paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 12.sp))
    Text(
        buildAnnotatedString {
            ingredients.forEach {
                if (it.measurementAmount != "") {
                    withStyle(style = paragraphStyle) {
                        append(bullet)
                        append("\t\t")
                        append(it.measurementAmount + " " + it.measurement + " " + it.name)
                    }
                } else {
                    withStyle(style = paragraphStyle) {
                        append(bullet)
                        append("\t\t")
                        append(it.measurementAmount + " " + it.name)
                    }
                }
            }
        },
        fontSize = 20.sp
    )
}

