package com.jaseem.apod.presentation.navigation

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jaseem.apod.presentation.screen.details.DetailsScreen

const val DetailsRoute = "Details"

const val titleArg = "title"
const val copyrightArg = "copyright"
const val dateArg = "date"
const val hdUrlArg = "hdUrl"
const val explanationArg = "explanation"

internal class DetailsArg(
    val title: String,
    val copyright: String?,
    val date: String,
    val hdUrl: String,
    val explanation: String
) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        Uri.decode(checkNotNull(savedStateHandle[titleArg]) as String),
        Uri.decode(savedStateHandle[copyrightArg] ?: ""),
        Uri.decode(checkNotNull(savedStateHandle[dateArg]) as String),
        Uri.decode(checkNotNull(savedStateHandle[hdUrlArg]) as String),
        Uri.decode(checkNotNull(savedStateHandle[explanationArg]) as String)
    )
}

fun NavGraphBuilder.details(
    onClickBack: () -> Unit
) {
    composable(
        route = "$DetailsRoute/{$titleArg}/{$copyrightArg}/{$dateArg}/{$hdUrlArg}/{$explanationArg}",
        arguments = listOf(
            navArgument(titleArg) { type = NavType.StringType },
            navArgument(copyrightArg) {
                type = NavType.StringType
                nullable = true
            },
            navArgument(dateArg) { type = NavType.StringType },
            navArgument(hdUrlArg) { type = NavType.StringType },
            navArgument(explanationArg) { type = NavType.StringType }
        )
    ) {
        DetailsScreen(onClickBack = onClickBack)
    }
}

fun NavController.navigateToDetails(
    title: String,
    copyright: String?,
    date: String,
    hdUrl: String,
    explanation: String
) {
    val encodedTitle = Uri.encode(title)
    val encodedCopyright = Uri.encode(copyright)
    val encodedDate = Uri.encode(date)
    val encodedHdUrl = Uri.encode(hdUrl)
    val encodedExplanation = Uri.encode(explanation)

    navigate(
        "$DetailsRoute/$encodedTitle/$encodedCopyright/" +
                "$encodedDate/$encodedHdUrl/$encodedExplanation"
    )
}