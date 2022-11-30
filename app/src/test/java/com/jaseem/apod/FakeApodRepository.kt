package com.jaseem.apod

import com.jaseem.apod.fakedata.inValidData
import com.jaseem.apod.data.network.DataState
import com.jaseem.apod.data.network.Error
import com.jaseem.apod.data.network.Success
import com.jaseem.apod.data.network.model.CosmosRemote
import com.jaseem.apod.data.network.repository.ApodRepository
import com.jaseem.apod.fakedata.validData

class FakeApodRepository(
    private val getSuccess: Boolean,
    private val getValid: Boolean
) : ApodRepository {

    override suspend fun getAll(): DataState<List<CosmosRemote>> {
        if (getSuccess) {
            if (getValid) {
                return Success(validData)
            }

            return Success(inValidData)
        }

        return Error(message = "Something went wrong!")
    }
}