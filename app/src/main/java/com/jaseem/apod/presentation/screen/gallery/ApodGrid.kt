package com.jaseem.apod.presentation.screen.gallery

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jaseem.apod.data.network.model.Cosmos

@Composable
fun ApodGrid(
    items: List<Cosmos>,
    modifier: Modifier,
    onClickCard: (cosmos: Cosmos) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier
    ) {
        items(items) { listItem ->
            ApodGridItem(
                title = listItem.title,
                imageUrl = listItem.url,
                copyright = listItem.copyright,
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(0.778f)
                    .clickable {
                        onClickCard(listItem)
                    }
            )
        }
    }
}