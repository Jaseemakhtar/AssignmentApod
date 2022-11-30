package com.jaseem.apod.di

import com.jaseem.apod.data.network.service.RetrofitApodApi
import com.jaseem.apod.data.network.repository.ApodRepository
import com.jaseem.apod.data.network.repository.ApodRespositoryImpl
import com.jaseem.apod.domain.usecase.DateFormatParserUseCase
import com.jaseem.apod.domain.usecase.GetSortedCosmosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApodModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApodService(retrofit: Retrofit): RetrofitApodApi =
        retrofit.create(RetrofitApodApi::class.java)

    @Provides
    @Singleton
    fun provideApodRepository(retrofitApodApi: RetrofitApodApi): ApodRepository =
        ApodRespositoryImpl(retrofitApodApi)

    @Provides
    @Singleton
    fun provideDateFormatParser(): DateFormatParserUseCase = DateFormatParserUseCase()

    @Provides
    @Singleton
    fun provideGetSortedCosmos(
        apodRepository: ApodRepository,
        dateFormatParserUseCase: DateFormatParserUseCase
    ) = GetSortedCosmosUseCase(apodRepository, dateFormatParserUseCase)
}
