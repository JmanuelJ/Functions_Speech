package com.example.functionsspeech.presentation.screens.texttospeech

import com.example.functionsspeech.domain.model.Response

data class TextToSpeechState (
    var speechResponse: Response<ByteArray?>? = null,
    var btnPlay: Boolean = false,
    var text: String = ""
)