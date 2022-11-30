package com.jaseem.apod.presentation.screen.gallery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jaseem.apod.R
import com.jaseem.apod.domain.Cosmos
import com.jaseem.apod.domain.state.UiState
import com.jaseemakhtar.compose.shimmer.shimmer

@Composable
fun GalleryScreen(
    onClickCard: (cosmos: Cosmos) -> Unit,
    viewModel: GalleryViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (val uiState = viewModel.uiState.value) {
            UiState.Loading -> {
                LoadingSkeleton(
                    modifier = Modifier
                        .fillMaxSize()
                        .shimmer()
                )
            }

            is UiState.Error -> {
                Text(text = uiState.message)
            }

            is UiState.Success -> {
                Column(modifier = Modifier.fillMaxSize()) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_menu),
                        contentDescription = "Menu Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(top = 8.dp, start = 16.dp)
                            .size(42.dp)
                            .padding(8.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.title_lets_explore).uppercase(),
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.title_cosmos).uppercase(),
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                    ApodGrid(
                        items = uiState.data,
                        modifier = Modifier
                            .padding(top = 14.dp)
                            .fillMaxWidth()
                            .weight(1f),
                        onClickCard = onClickCard
                    )
                }
            }
        }
    }
}
