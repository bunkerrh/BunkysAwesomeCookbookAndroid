package com.bunkware.bunkyrecipe.utils

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun NiceButton(
    title: String,
    textColor: Color = primaryTextColor,
    backgroundColor: Color = primaryColor,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(smallSpace)
            .height(normalTouchableHeight),
        shape = RoundedCornerShape(30),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = textColor,
            backgroundColor = backgroundColor
        )
    ) {
        Text(title)
    }
}
