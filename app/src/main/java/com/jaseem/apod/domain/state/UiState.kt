package com.jaseem.apod.domain.state


sealed interface UiState<out T> {
    object Loading: UiState<Nothing>
    data class Success<T>(val data: T) : UiState<T>
    data class Error(val message: String) : UiState<Nothing>
}
