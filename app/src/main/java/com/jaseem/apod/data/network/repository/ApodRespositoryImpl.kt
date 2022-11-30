package com.jaseem.apod.data.network.repository

import com.jaseem.apod.data.network.DataState
import com.jaseem.apod.data.network.Error
import com.jaseem.apod.data.network.Success
import com.jaseem.apod.data.network.model.CosmosRemote
import com.jaseem.apod.data.network.service.RetrofitApodApi
import javax.inject.Inject

class ApodRespositoryImpl @Inject constructor(
    private val retrofitApodApi: RetrofitApodApi
) : ApodRepository {

    override suspend fun getAll(): DataState<List<CosmosRemote>> =
        try {
            val response = retrofitApodApi.getAllCosmos()

            if (response.isSuccessful) {
                Success(response.body()!!)
            } else {
                Error(response.message())
            }
        } catch (e: Exception) {
            Error(e.message ?: "Unknown state")
        }

}
