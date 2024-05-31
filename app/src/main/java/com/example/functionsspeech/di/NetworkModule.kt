package com.example.functionsspeech.di

import com.example.functionsspeech.data.network.ApiService
import com.example.functionsspeech.data.repository.ServiceRepositoryImpl
import com.example.functionsspeech.domain.repository.ServiceRepository
import com.example.functionsspeech.domain.usecases.services.ServicesUseCases
import com.example.functionsspeech.domain.usecases.services.TextToSpeechUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.elevenlabs.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideTextToSpeechApiClient(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideServiceRepository(impl: ServiceRepositoryImpl): ServiceRepository = impl

    @Provides
    fun providesServicesUseCase(repository: ServiceRepository) = ServicesUseCases(
        textToSpeech = TextToSpeechUseCase(repository = repository)
    )

}