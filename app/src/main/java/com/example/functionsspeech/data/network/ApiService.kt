package com.example.functionsspeech.data.network

import com.example.functionsspeech.data.model.TextToSpeechData
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("/v1/text-to-speech/{voice_id}/stream")
    @Headers(
        "Accept: audio/mpeg",
        "Content-Type: application/json",
        "xi-api-key: Aqui pon tu api key"
    )
    suspend fun textToSpeech(
        @Path("voice_id") voice: String,
        @Body data: TextToSpeechData
    ): Response<ResponseBody>
}
