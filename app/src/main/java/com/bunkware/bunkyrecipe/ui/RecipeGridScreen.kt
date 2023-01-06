package com.bunkware.bunkyrecipe.views.recipeGridView
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bunkware.bunkyrecipe.models.Recipe
import com.bunkware.bunkyrecipe.utils.*




@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
fun RecipeGridScreen(
    recipeList: ArrayList<Recipe>,
    onGridButtonClick: (Recipe) -> Unit
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f)
    ) {
        items(recipeList) { item ->
            Card(
                modifier = Modifier.padding(2.dp),
                backgroundColor = primaryColor,
                onClick = {onGridButtonClick(item)}
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
                        painter = painterResource(item.image),
                        contentDescription = "Strogonoff",
                        contentScale = ContentScale.Crop,
                        modifier = imageModifier,
                        alignment = Alignment.Center

                    )
                    Spacer(Modifier.width(normalRadius))
                    Text(
                        item.name,
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