package com.jaseem.apod.domain.util

import com.jaseem.apod.data.network.model.CosmosRemote
import com.jaseem.apod.domain.Cosmos

@Throws
fun List<CosmosRemote>.toEntity(): List<Cosmos> {
    var index = 0
    return mapNotNull {
        try {
            Cosmos(
                copyright = it.copyright ?: "",
                date = it.date ?: "",
                explanation = checkNotNull(it.explanation),
                hdurl = it.hdurl ?: "",
                title = checkNotNull(it.title),
                url = it.url ?: "",
                id = index++
            )
        } catch (e: Exception) {
            return@mapNotNull null
        }
    }
}
