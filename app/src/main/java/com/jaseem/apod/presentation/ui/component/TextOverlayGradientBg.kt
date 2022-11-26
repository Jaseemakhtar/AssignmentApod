package com.jaseem.apod.presentation.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path

@Composable
fun TextOverlayGradientBg(modifier: Modifier) {
    val background = remember {
        Path()
    }

    Canvas(modifier = modifier) {
        background.reset()
        background.addRect(Rect(0f, 0f, size.width, size.height))

        drawPath(
            path = background,
            brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF1A232B).copy(alpha = 0f),
                    Color(0xFF22333F)
                ),
                start = Offset(size.center.x, 0f),
                end = Offset(size.center.x, size.height)
            )
        )
    }
}