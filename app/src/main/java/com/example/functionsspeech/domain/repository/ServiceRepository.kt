package com.example.functionsspeech.domain.repository

import com.example.functionsspeech.data.model.TextToSpeechData
import com.example.functionsspeech.domain.model.Response

interface ServiceRepository {

    suspend fun textToSpeechService(voice: String, data: TextToSpeechData): Response<ByteArray?>
}