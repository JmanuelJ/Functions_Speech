package com.example.functionsspeech.presentation.screens.texttospeech

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.functionsspeech.domain.model.Response
import com.example.functionsspeech.presentation.components.ProgresBar

@Composable
fun TextTo(viewModel: TextToSpeechViewModel) {

    when (val result = viewModel.speechResponse) {
        is Response.Error ->{
            Toast.makeText(
                LocalContext.current,
                "Error Signup: ${result.errorMessage}",
                Toast.LENGTH_SHORT
            ).show()
        }
        Response.Loading ->{
            ProgresBar()
        }
        is Response.Success -> {
            viewModel.initSound(LocalContext.current,result.data!!)
        }
        null -> {}
    }

}