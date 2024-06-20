package com.example.functionsspeech.presentation.screens.texttospeech

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.functionsspeech.core.Constants.VOICE_NUMBER_ONE
import com.example.functionsspeech.data.model.TextToSpeechData
import com.example.functionsspeech.domain.model.Response
import com.example.functionsspeech.domain.usecases.services.ServicesUseCases
import com.example.functionsspeech.utils.CreateFileSound
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class TextToSpeechViewModel @Inject constructor(
    private val servicesUseCases: ServicesUseCases
) : ViewModel() {
    private val createFileSound = CreateFileSound()
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var file: File

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    private var btnPlay by mutableStateOf(false)

    var speechResponse by mutableStateOf<Response<ByteArray?>?>(null)

    fun onTexInput(text: String) {
        _text.value = text
    }

    fun getSpeech() {
        val obj = createBody()
        viewModelScope.launch {
            speechResponse = Response.Loading
            val result = servicesUseCases.textToSpeech(VOICE_NUMBER_ONE, obj)
            speechResponse = result
        }
    }

    private fun createBody(): TextToSpeechData {
        return TextToSpeechData(
            text = text.value ?: "",
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
        btnPlay = btnPlay != true
    }

    private fun onPlayPauseSound() {
        if (btnPlay) {
            mediaPlayer.prepare()
            mediaPlayer.start()
        } else {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }

    fun onReset(){
        speechResponse = null
        onTexInput("")
    }

}