package com.bunkware.bunkyrecipe.ui

import android.graphics.BitmapFactory
import android.util.Log
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bunkware.bunkyrecipe.ui.recipe.RecipeViewModel
import com.bunkware.bunkyrecipe.utils.*
import com.bunkware.bunkyrecipe.recipe.models.*



@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun RecipeGridScreen(
    onGridButtonClick: (Recipe) -> Unit
) {
    val recipeViewModel = viewModel(modelClass = RecipeViewModel::class.java)
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

            Log.d(
                "Decoding Images",
                "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
            )
            //val decodedString = Base64.getDecoder().decode(item.image)
            val decodedString = android.util.Base64.decode(item.foodPic, android.util.Base64.DEFAULT)
            Log.d("tag", decodedString.size.toString())

            val decodedImage =
                BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size - 1)
            Log.d("After Decoding", decodedImage.toString())

            Card(
                modifier = Modifier.padding(2.dp),
                backgroundColor = primaryColor,
                onClick = {
                    recipeViewModel.setRecipe(item)
                    onGridButtonClick(item) }
            )
            {
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                )
                {
                    val imageModifier = Modifier
                        .size(150.dp)
                    Image(
                        bitmap = decodedImage.asImageBitmap(),
                        contentDescription = "Strogonoff",
                        contentScale = ContentScale.Crop,
                        modifier = imageModifier,
                        alignment = Alignment.Center

                    )
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