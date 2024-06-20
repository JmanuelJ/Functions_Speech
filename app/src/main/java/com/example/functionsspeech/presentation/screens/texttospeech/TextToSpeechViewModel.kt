package com.example.functionsspeech.presentation.screens.texttospeech

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.functionsspeech.core.Constants.VOICE_NUMBER_ONE
import com.example.functionsspeech.data.model.TextToSpeechData
import com.example.functionsspeech.domain.model.Response
import com.example.functionsspeech.domain.usecases.services.ServicesUseCases
import com.example.functionsspeech.utils.CreateFileSound
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class TextToSpeechViewModel @Inject constructor(
    private val servicesUseCases: ServicesUseCases
) : ViewModel() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var file: File

    private val _state = MutableStateFlow(TextToSpeechState())
    val state: StateFlow<TextToSpeechState> = _state.asStateFlow()

    private val createFileSound = CreateFileSound()

    fun onTexInput(text: String) {
        _state.update {
            it.copy(
                text = text
            )
        }
    }

    fun getSpeech() {
        val obj = createBody()
        viewModelScope.launch {
            _state.update {
                it.copy(
                    speechResponse = Response.Loading
                )
            }
            val result = servicesUseCases.textToSpeech(VOICE_NUMBER_ONE, obj)
            _state.update {
                it.copy(
                    speechResponse = result
                )
            }
        }
    }

    private fun createBody(): TextToSpeechData {
        return TextToSpeechData(
            text = state.value.text,
            modelid = "eleven_monolingual_v1"
        )
    }

    fun initSound(context: Context, array: ByteArray) {
        file = getFileSound(array)
        val fileUri = createFileSound.createUri(file, context)
        mediaPlayer = MediaPlayer()
        mediaPlayer.setDataSource(context, fileUri)
    }

    private fun getFileSound(array: ByteArray): File {
        return createFileSound.createSound(array)
    }

    fun onValuePlay() {
        onButtonPlay()
        onPlayPauseSound()
    }

    private fun onButtonPlay() {
        _state.update {
            it.copy(
                btnPlay = !it.btnPlay
            )
        }
    }

    private fun onPlayPauseSound() {
        if (state.value.btnPlay) {
            mediaPlayer.prepare()
            mediaPlayer.start()
        } else {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }

    fun onReset() {
        _state.update {
            it.copy(
                speechResponse = null,
                btnPlay = false,
                text = ""
            )
        }
    }

}