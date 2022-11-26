package com.jaseem.apod.presentation.screen.gallery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jaseem.apod.presentation.ui.theme.RiverBed500

@Composable
fun LoadingSkeleton(modifier: Modifier) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .padding(top = 8.dp, start = 16.dp)
                .size(42.dp)
                .padding(8.dp)
                .background(RiverBed500)
        )

        Box(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .size(134.dp, 48.dp)
                .background(RiverBed500)
        )

        Box(
            modifier = Modifier
                .padding(top = 4.dp)
                .padding(horizontal = 24.dp)
                .size(148.dp, 26.dp)
                .background(RiverBed500)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier
                .padding(top = 14.dp)
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(count = 6) {
                Box(
                    modifier = Modifier
                        .background(RiverBed500)
                        .fillMaxWidth()
                        .aspectRatio(0.778f)
                )
            }
        }
    }
}
