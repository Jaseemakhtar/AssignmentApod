package com.jaseem.apod.domain.usecase

import com.jaseem.apod.data.network.Error
import com.jaseem.apod.data.network.Success
import com.jaseem.apod.data.network.repository.ApodRepository
import com.jaseem.apod.domain.Cosmos
import com.jaseem.apod.domain.state.UiState
import com.jaseem.apod.domain.util.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSortedCosmosUseCase @Inject constructor(
    private val apodRepository: ApodRepository,
    private val dateFormatParserUseCase: DateFormatParserUseCase
) {

    operator fun invoke(): Flow<UiState<List<Cosmos>>> = flow {
        emit(UiState.Loading)

        when (val res = apodRepository.getAll()) {
            is Error -> {
                emit(UiState.Error(res.message))
            }

            is Success -> {
                emit(
                    UiState.Success(
                        res.data
                            .toEntity()
                            .sortedByDescending {
                                dateFormatParserUseCase(it.date)
                            }
                    )
                )
            }
        }
    }
}
