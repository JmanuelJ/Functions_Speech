package com.example.functionsspeech.presentation.screens.texttospeech

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.functionsspeech.domain.model.Response
import com.example.functionsspeech.presentation.components.ProgressBar
import com.example.functionsspeech.presentation.screens.texttospeech.components.CustomTextField
import com.example.functionsspeech.presentation.screens.texttospeech.components.HeaderTtp
import com.example.functionsspeech.presentation.screens.texttospeech.components.Player
import com.example.functionsspeech.presentation.screens.texttospeech.components.ShowError

@Composable
fun TextToSpeechScreen(
    viewModel: TextToSpeechViewModel
) {
    val state by viewModel.state.collectAsState()

    Column {
        HeaderTtp()
        when (val response = state.speechResponse) {
            is Response.Error -> {
                ShowError(errorMessage = response.errorMessage)
            }

            Response.Loading -> {
                ProgressBar(modifier = Modifier.fillMaxSize())
            }

            is Response.Success -> {
                response.data?.let {
                    viewModel.initSound(LocalContext.current, it)
                }
                Player(
                    onPlayPause = {
                        viewModel.onValuePlay()
                    },
                    onReset = {
                        viewModel.onReset()
                    }
                )
            }

            null -> {
                CustomTextField(
                    text = state.text,
                    textInput = {
                        viewModel.onTexInput(it)
                    },
                    getSpeech = {
                        viewModel.getSpeech()
                    }
                )
            }
        }
    }
}







