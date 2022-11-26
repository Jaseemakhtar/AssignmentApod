package com.jaseem.apod.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jaseem.apod.presentation.navigation.GalleryRoute
import com.jaseem.apod.presentation.navigation.details
import com.jaseem.apod.presentation.navigation.gallery
import com.jaseem.apod.presentation.navigation.navigateToDetails
import com.jaseem.apod.presentation.ui.component.LinearGradientBg

@Composable
fun ApodScreen(
    modifier: Modifier,
    onClickBack: () -> Unit
) {
    val navController = rememberNavController()

    Box(modifier = modifier) {
        LinearGradientBg(modifier = Modifier.fillMaxSize())

        NavHost(
            navController = navController,
            startDestination = GalleryRoute,
            modifier = Modifier.fillMaxSize()
        ) {
            gallery(
                onClickCard = {
                    navController.navigateToDetails(
                        title = it.title,
                        copyright = it.copyright,
                        date = it.date,
                        hdUrl = it.hdurl,
                        explanation = it.explanation
                    )
                }
            )

            details(onClickBack = onClickBack)
        }
    }
}