package com.jaseem.apod.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jaseem.apod.presentation.navigation.GalleryRoute
import com.jaseem.apod.presentation.navigation.details
import com.jaseem.apod.presentation.navigation.gallery

@Composable
fun ApodScreen(
    modifier: Modifier,
    onClickBack: () -> Unit
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = GalleryRoute,
        modifier = modifier
    ) {
        gallery(
            onClickBack = onClickBack,
            onClickCard = {
//                navController.navigateToDetails()
            }
        )

        details(onClickBack = onClickBack)
    }
}