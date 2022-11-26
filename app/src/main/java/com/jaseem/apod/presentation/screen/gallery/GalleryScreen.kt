package com.jaseem.apod.presentation.screen.gallery

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.jaseem.apod.domain.state.Error
import com.jaseem.apod.domain.state.Loading
import com.jaseem.apod.domain.state.Success

@Composable
fun GalleryScreen(
    onClickBack: () -> Unit,
    onClickCard: () -> Unit,
    viewModel: GalleryViewModel = hiltViewModel()
) {
    when(viewModel.uiState.value) {
        Loading -> TODO()
        is Error -> TODO()
        is Success -> TODO()
    }
}