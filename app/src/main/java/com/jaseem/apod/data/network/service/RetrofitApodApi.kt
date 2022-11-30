package com.jaseem.apod.data.network.service

import com.jaseem.apod.data.network.model.CosmosRemote
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitApodApi {

    @GET("obvious/take-home-exercise-data/trunk/nasa-pictures.json")
    suspend fun getAllCosmos(): Response<List<CosmosRemote>>
}
