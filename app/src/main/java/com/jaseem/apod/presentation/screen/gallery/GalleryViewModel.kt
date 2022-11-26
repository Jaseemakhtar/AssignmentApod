package com.jaseem.apod.presentation.screen.gallery

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jaseem.apod.data.network.model.Cosmos
import com.jaseem.apod.domain.repository.ApodRepository
import com.jaseem.apod.domain.state.DataState
import com.jaseem.apod.domain.state.Loading
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val apodRepository: ApodRepository
) : ViewModel() {

    val uiState: MutableState<DataState<List<Cosmos>>> = mutableStateOf(Loading)

    init {
        fetchAllApods()
    }

    private fun fetchAllApods() {
        apodRepository.getAll().onEach {
            uiState.value = it
        }.launchIn(viewModelScope)
    }
}
