package com.jaseem.apod.presentation.screen.gallery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jaseem.apod.data.network.model.Cosmos
import com.jaseem.apod.domain.state.Error
import com.jaseem.apod.domain.state.Loading
import com.jaseem.apod.domain.state.Success

@Composable
fun GalleryScreen(
    onClickBack: () -> Unit,
    onClickCard: (cosmos: Cosmos) -> Unit,
    viewModel: GalleryViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (val uiState = viewModel.uiState.value) {
            Loading -> {
                CircularProgressIndicator()
            }

            is Error -> {
                Text(
                    text = uiState.message
                )
            }

            is Success -> {
                ApodGrid(
                    items = uiState.data,
                    modifier = Modifier.fillMaxSize(),
                    onClickCard = onClickCard
                )
            }
        }
    }
}
