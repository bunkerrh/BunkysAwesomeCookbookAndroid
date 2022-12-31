package com.bunkware.bunkyrecipe.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.bunkware.bunkyrecipe.utils.*
import kotlin.math.max

enum class RowType {
    TOP, MIDDLE, BOTTOM, SINGLE
}


@Composable
fun HomeListItem (
    title: String,
    subTitle: String,
    type: RowType,
    editMode: Boolean = false,
    onClick: () -> Unit,
    onDelete: () -> Unit
) {

// Here we are settng the shape of hte rows.
// Top row will have top left and right corners rounded
// Middle rows will have sqaure corners
// rows all by their lonesomes will be all corners rounded
// bottom row will be square top and rounded bottom

    val shape = when (type) {
        RowType.TOP -> {
            RoundedCornerShape(normalRadius, normalRadius)
        }
        // If i understand this correctly.
        // we are setting the shapes starting in the top left and working clockwise
        // no radius i bet is to change nothing
        RowType.BOTTOM -> {
            RoundedCornerShape(
                noRadius,
                noRadius,
                normalRadius,
                normalRadius
            )
        }
        RowType.SINGLE -> {
            RoundedCornerShape(
                normalRadius,
                normalRadius,
                normalRadius,
                normalRadius
            )
        }
        else -> {
            RoundedCornerShape(noRadius)
        }
    }
    Column{
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { onClick() }
                .padding(normalSpace, noSpace, normalSpace, noSpace)
                .fillMaxWidth()
                .height(rowHeight)
                .clip(shape)
                .background(color = primaryClor)

        ){
            var deleteMode by remember { mutableStateOf(false)}
            if(editMode && !deleteMode) {
                Button(
                    onClick = {
                        deleteMode = !deleteMode
                    }, modifier = Modifier
                        .width(deleteIconButtonWidth)
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(noRadius),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.Red,
                        backgroundColor = primaryClor
                    )

                ) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "delete",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
                }
            }
            Column(Modifier.weight(1f)) {
                Column (
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(normalSpace)
                    ) {
                    Text(
                        title,
                        style = MaterialTheme.typography.subtitle1,
                        color = primaryTextColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(Modifier.height(smallSpace))
                    Text(
                        subTitle,
                        style = MaterialTheme.typography.subtitle2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            if(!editMode && !deleteMode)
            {
                Icon(
                    imageVector = Icons.Filled.ChevronRight,

                )
            }
        }
    }
    if(type != RowType.BOTTOM && type != RowType.SINGLE)
    {
        Divider(
            modifier = Modifier
                .padding(normalSpace, noSpace, normalSpace, noSpace),
                // look at that offwhite coloring
                color = Color.LightGray,
                // that subtle thickness
                thickness = dividerNormalThickness
        )
    }
}