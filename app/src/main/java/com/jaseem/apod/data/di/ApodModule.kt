package com.jaseem.apod.data.di

import com.jaseem.apod.data.network.service.ApodService
import com.jaseem.apod.domain.repository.ApodRepository
import com.jaseem.apod.domain.repository.ApodRespositoryImpl
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
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApodService(retrofit: Retrofit): ApodService =
        retrofit.create(ApodService::class.java)

    @Provides
    @Singleton
    fun provideApodRepository(apodService: ApodService): ApodRepository =
        ApodRespositoryImpl(apodService)
}
