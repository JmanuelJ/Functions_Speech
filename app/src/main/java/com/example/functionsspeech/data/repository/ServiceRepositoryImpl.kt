package com.example.functionsspeech.data.repository

import com.example.functionsspeech.data.model.TextToSpeechData
import com.example.functionsspeech.data.network.ApiService
import com.example.functionsspeech.domain.model.Response
import com.example.functionsspeech.domain.repository.ServiceRepository
import retrofit2.Retrofit
import javax.inject.Inject

class ServiceRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val retrofit: Retrofit
): ServiceRepository {

    override suspend fun textToSpeechService(
        voice: String,
        data: TextToSpeechData
    ): Response<ByteArray?> {
        return try{
            val response = api.textToSpeech(voice, data)
            val array = response.body()?.bytes()!!
            Response.Success(array)
        }catch (e: Exception) {
            Response.Error(e.message ?: "Error de servicio")
        }
    }

}