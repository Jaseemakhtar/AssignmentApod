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
    titleArg: String,
    copyrightArg: String,
    dateArg: String,
    hdUrlArg: String,
    explanationArg: String
) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        checkNotNull(savedStateHandle[titleArg]),
        checkNotNull(savedStateHandle[copyrightArg]),
        checkNotNull(savedStateHandle[dateArg]),
        checkNotNull(savedStateHandle[hdUrlArg]),
        checkNotNull(savedStateHandle[explanationArg])
    )
}

fun NavGraphBuilder.details(
    onClickBack: () -> Unit
) {
    composable(
        route = DetailsRoute,
        arguments = listOf(
            navArgument(titleArg) {type = NavType.StringType},
            navArgument(copyrightArg) {type = NavType.StringType},
            navArgument(dateArg) {type = NavType.StringType},
            navArgument(hdUrlArg) {type = NavType.StringType},
            navArgument(explanationArg) {type = NavType.StringType}
        )
    ) {
        DetailsScreen(onClickBack = onClickBack)
    }
}

fun NavController.navigateToDetails(
    title: String,
    copyright: String,
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