package com.jaseem.apod.domain.repository

import com.jaseem.apod.data.network.model.Cosmos
import com.jaseem.apod.domain.state.DataState
import kotlinx.coroutines.flow.Flow

interface ApodRepository {
    fun getAll(): Flow<DataState<List<Cosmos>>>
}
