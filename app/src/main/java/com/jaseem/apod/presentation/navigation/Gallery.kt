package com.jaseem.apod.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jaseem.apod.data.network.model.Cosmos
import com.jaseem.apod.presentation.screen.gallery.GalleryScreen

const val GalleryRoute = "Gallery"


fun NavGraphBuilder.gallery(
    onClickBack: () -> Unit,
    onClickCard: (card: Cosmos) -> Unit
) {
    composable(
        route = GalleryRoute
    ) {
        GalleryScreen(
            onClickBack = onClickBack,
            onClickCard = onClickCard
        )
    }
}
