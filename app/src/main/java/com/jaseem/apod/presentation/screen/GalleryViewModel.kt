package com.jaseem.apod.presentation.screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jaseem.apod.domain.Cosmos
import com.jaseem.apod.domain.state.UiState
import com.jaseem.apod.domain.usecase.GetSortedCosmosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val getSortedCosmos: GetSortedCosmosUseCase
) : ViewModel() {

    val uiState: MutableState<UiState<List<Cosmos>>> = mutableStateOf(UiState.Loading)

    init {
        fetchAllApods()
    }

    private fun fetchAllApods() {
        getSortedCosmos().onEach {
            uiState.value = it
        }.launchIn(viewModelScope)
    }
}
