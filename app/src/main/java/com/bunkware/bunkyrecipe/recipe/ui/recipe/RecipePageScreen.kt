package com.bunkware.bunkyrecipe.views.recipeGridView

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bunkware.bunkyrecipe.recipe.models.*
import com.bunkware.bunkyrecipe.utils.*

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
                recipe.recipeName,
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
fun InstructionColumn(instructions: List<Instruction>) {
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
                "" + it.stepNo + ". " + it.stepInstructions,
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
fun IngredientColumn(ingredients: List<Ingredient>) {
    var bullet = "\u2022"
    var paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 12.sp))
    Text(
        buildAnnotatedString {
            ingredients.forEach {
                if (it.measurementAmount != "" && it.measurement != "to taste") {
                    withStyle(style = paragraphStyle) {
                        append(bullet)
                        append("\t\t")
                        append(it.measurementAmount + " " + it.measurement + " " + it.name)
                    }
                } else if (it.measurement == "to taste") {
                    withStyle(style = paragraphStyle) {
                        append(bullet)
                        append("\t\t")
                        append(it.name + " " + it.measurement)
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

