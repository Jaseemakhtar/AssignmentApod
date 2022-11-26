package com.jaseem.apod.data.network.service

import com.jaseem.apod.data.network.model.Cosmos
import retrofit2.Response
import retrofit2.http.GET

interface ApodService {

    @GET("obvious/take-home-exercise-data/trunk/nasa-pictures.json")
    suspend fun getAllCosmos(): Response<List<Cosmos>>
}
