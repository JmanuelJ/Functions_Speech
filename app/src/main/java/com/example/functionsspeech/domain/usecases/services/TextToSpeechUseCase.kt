package com.example.functionsspeech.domain.usecases.services

import com.example.functionsspeech.data.model.TextToSpeechData
import com.example.functionsspeech.domain.repository.ServiceRepository
import javax.inject.Inject

class TextToSpeechUseCase @Inject constructor(
    private val repository: ServiceRepository
) {
    suspend operator fun invoke(
        voice: String,
        data: TextToSpeechData
    ) = repository.textToSpeechService(voice, data)
}