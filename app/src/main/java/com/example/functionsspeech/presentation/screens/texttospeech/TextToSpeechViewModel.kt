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
class TextToSpeechViewModel  @Inject constructor(
    private val servicesUseCases: ServicesUseCases
) : ViewModel() {
    private val createFileSound = CreateFileSound()
    lateinit var  mediaPlayer: MediaPlayer
    lateinit var file: File

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    private val _playerEnable = MutableLiveData<Boolean>()
    val playerEnable: LiveData<Boolean> = _playerEnable

    private val _btnPlay = MutableLiveData<Boolean>()
    val btnPlay: LiveData<Boolean> = _btnPlay

    var speechResponse by mutableStateOf<Response<ByteArray?>?>(null)

    fun onTexInput(text: String) {
        _text.value = text
    }

    fun onPlayerEnable() {
        if(_playerEnable.value!! ){
            _playerEnable.value = false
        }
        else{
            _playerEnable.value = true
        }
    }

    fun onButtonPlay(state: Boolean) {
        _btnPlay.value = state
    }

    fun getSpeech() {
        val obj = createBody()
        viewModelScope.launch {
            speechResponse = Response.Loading
            val result = servicesUseCases.textToSpeech( VOICE_NUMBER_ONE ,obj)
            speechResponse = result
        }
    }

    private fun createBody(): TextToSpeechData {
        return TextToSpeechData(
            text = text.value!!,
            modelid = "eleven_monolingual_v1",
        )
    }

    fun initSound(context: Context, array: ByteArray){
        file = getFileSound(array)
        val fileUri = createFileSound.createUri(file,context)
        mediaPlayer = MediaPlayer()
        mediaPlayer.setDataSource(context,fileUri)
    }


    fun getFileSound(array: ByteArray): File{
        return createFileSound.createSound(array)
    }

    fun playPauseSound(){
        if(btnPlay.value!!){
            mediaPlayer.prepare()
            mediaPlayer.start()
        } else{
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }

}