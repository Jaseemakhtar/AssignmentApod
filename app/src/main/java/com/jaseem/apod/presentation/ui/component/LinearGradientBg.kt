package com.jaseem.apod.presentation.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path

@Composable
fun LinearGradientBg(modifier: Modifier) {
    val background = remember {
        Path()
    }

    Canvas(modifier = modifier) {
        background.reset()
        background.addRect(Rect(0f, 0f, size.width, size.height))

        drawPath(
            path = background,
            brush = Brush.linearGradient(
                start = Offset.Zero,
                end = Offset(size.width, size.height),
                colors = listOf(
                    Color(0xFF22333F),
                    Color(0xFF151A20)
                )
            )
        )
    }
}