package com.jaseem.apod.domain.repository

import com.jaseem.apod.data.network.model.Cosmos
import com.jaseem.apod.data.network.service.ApodService
import com.jaseem.apod.domain.state.Error
import com.jaseem.apod.domain.state.Loading
import com.jaseem.apod.domain.state.DataState
import com.jaseem.apod.domain.state.Success
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApodRespositoryImpl @Inject constructor(
    private val apodService: ApodService
) : ApodRepository {

    override fun getAll(): Flow<DataState<List<Cosmos>>> = flow {
        emit(Loading)
        try {
            val response = apodService.getAllCosmos()

            if (response.isSuccessful) {
                emit(Success(response.body()!!))
            } else {
                emit(Error(response.message()))
            }
        } catch (e: Exception) {
            emit(Error(e.message ?: "Unknown state"))
        }
    }
}
