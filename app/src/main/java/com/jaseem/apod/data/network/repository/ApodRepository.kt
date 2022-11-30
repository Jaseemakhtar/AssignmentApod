package com.jaseem.apod.data.network.repository

import com.jaseem.apod.data.network.model.CosmosRemote
import com.jaseem.apod.data.network.DataState

interface ApodRepository {
    suspend fun getAll(): DataState<List<CosmosRemote>>
}
