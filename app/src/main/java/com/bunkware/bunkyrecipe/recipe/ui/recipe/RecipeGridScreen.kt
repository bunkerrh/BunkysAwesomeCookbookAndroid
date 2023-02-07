package com.bunkware.bunkyrecipe.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bunkware.bunkyrecipe.ui.recipe.RecipeViewModel
import com.bunkware.bunkyrecipe.utils.*
import com.bunkware.bunkyrecipe.recipe.models.*


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun RecipeGridScreen(
    onGridButtonClick: (Recipe) -> Unit
) {
    val recipeViewModel = hiltViewModel<RecipeViewModel>()
    val state by recipeViewModel.state.collectAsState()

    val recipeList = state

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f)
    ) {
        items(recipeList) { item ->

            val decodedMap = getImageBitMap(item)

            Card(
                modifier = Modifier.padding(2.dp),
                backgroundColor = primaryColor,
                onClick = {
                    recipeViewModel.setRecipe(item)
                    onGridButtonClick(item)
                }
            )
            {
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                )
                {
                    val imageModifier = Modifier
                        .size(150.dp)
                    if (decodedMap != null) {
                        Image(
                            bitmap = decodedMap.asImageBitmap(),
                            contentDescription = item.recipeName,
                            contentScale = ContentScale.Crop,
                            modifier = imageModifier,
                            alignment = Alignment.Center

                        )
                    }

                    Spacer(Modifier.width(normalRadius))
                    Text(
                        item.recipeName,
                        style = MaterialTheme.typography.subtitle1,
                        color = primaryTextColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.width(normalRadius))
                    Text(
                        text = "Cook Time: ${item.timeHours}:${item.timeMinutes}:${item.timeSeconds}",
                        style = MaterialTheme.typography.subtitle1,
                        color = primaryTextColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
private fun getImageBitMap(item: Recipe): Bitmap? {
    var encodedString = item.foodPic.split(",")
    val imageBytes = Base64.decode(encodedString[1], Base64.DEFAULT)
    return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
}