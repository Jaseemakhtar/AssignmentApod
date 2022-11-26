package com.jaseem.apod.presentation.screen.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.jaseem.apod.presentation.navigation.DetailsArg
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val detailsArg = DetailsArg(savedStateHandle)

    val uiState: DetailsUiState
        get() = DetailsUiState(
            title = detailsArg.title,
            imageUrl = detailsArg.hdUrl,
            copyright = detailsArg.copyright ?: "",
            date = detailsArg.date,
            explanation = detailsArg.explanation
        )
}

data class DetailsUiState(
    val title: String,
    val imageUrl: String,
    val copyright: String,
    val date: String,
    val explanation: String,
)
