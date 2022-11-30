package com.jaseem.apod

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.jaseem.apod.fakedata.LatestDate
import com.jaseem.apod.data.network.Success
import com.jaseem.apod.domain.state.UiState
import com.jaseem.apod.domain.usecase.DateFormatParserUseCase
import com.jaseem.apod.domain.usecase.GetSortedCosmosUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetApodCosmosTest {
    private val dateFormatParser = DateFormatParserUseCase()

    @Test
    fun `Get All cosmos list, success`(): Unit = runBlocking {
        val repository = FakeApodRepository(getSuccess = true, getValid = true)

        val cosmosList = repository.getAll()

        assertThat((cosmosList as Success).data).isNotEmpty()
    }

    @Test
    fun `Discard invalid cosmos, success`(): Unit = runBlocking {
        val repository = FakeApodRepository(getSuccess = true, getValid = false)

        val getSortedCosmosUseCase = GetSortedCosmosUseCase(repository, dateFormatParser)

        getSortedCosmosUseCase().test {
            awaitItem() // loading

            val successState = awaitItem()

            assertThat((successState as UiState.Success).data).isEmpty()

            awaitComplete()
        }
    }

    @Test
    fun `Get All Sorted cosmos list`(): Unit = runBlocking {
        val repository = FakeApodRepository(getSuccess = true, getValid = true)

        val getSortedCosmosUseCase = GetSortedCosmosUseCase(repository, dateFormatParser)

        getSortedCosmosUseCase().test {
            awaitItem() // loading

            val successState = awaitItem()

            assertThat((successState as UiState.Success).data.first().date).isEqualTo(LatestDate)

            awaitComplete()
        }
    }
}
