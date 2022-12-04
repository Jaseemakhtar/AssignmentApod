package com.jaseem.apod.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.jaseem.apod.domain.state.UiState
import com.jaseem.apod.presentation.screen.details.DetailsScreen
import com.jaseem.apod.presentation.screen.gallery.GalleryScreen
import com.jaseem.apod.presentation.screen.GalleryViewModel
import com.jaseem.apod.presentation.screen.gallery.LoadingSkeleton
import com.jaseem.apod.presentation.ui.component.LinearGradientBg
import com.jaseemakhtar.compose.shimmer.shimmer

@Composable
fun ApodScreen(
    modifier: Modifier,
    viewModel: GalleryViewModel = hiltViewModel()
) {
    var currentPageId: Int by remember {
        mutableStateOf(0)
    }

    var detailsPageVisibility: Boolean by remember {
        mutableStateOf(false)
    }

    Box(modifier = modifier) {
        LinearGradientBg(modifier = Modifier.fillMaxSize())

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
                GalleryScreen(
                    cosmosList = uiState.data,
                    onClickCard = {
                        currentPageId = it.id
                        detailsPageVisibility = true
                    }
                )

                AnimatedVisibility(
                    visible = detailsPageVisibility,
                    enter = fadeIn() + slideInVertically(
                        initialOffsetY = { fullHeight ->
                            fullHeight
                        }
                    ),
                    exit = fadeOut() + slideOutVertically(
                        targetOffsetY = { fullHeight ->
                            fullHeight
                        },
                        animationSpec = tween(600)
                    )
                ) {
                    DetailsScreen(
                        currentPageId = currentPageId,
                        cosmosList = uiState.data,
                        onClickClose = {
                            detailsPageVisibility = false
                        }
                    )
                }
            }
        }
    }


    // Non UI
    // back press handler
    BackHandler(detailsPageVisibility) {
        detailsPageVisibility = false
    }
}