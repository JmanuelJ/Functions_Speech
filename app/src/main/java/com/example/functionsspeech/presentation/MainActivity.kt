package com.example.functionsspeech.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.functionsspeech.presentation.screens.texttospeech.TextToSpeechScreen
import com.example.functionsspeech.presentation.screens.texttospeech.TextToSpeechViewModel
import com.example.functionsspeech.presentation.ui.theme.FunctionsSpeechTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: TextToSpeechViewModel by viewModels()
        super.onCreate(savedInstanceState)
        setContent {
            FunctionsSpeechTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TextToSpeechScreen(
                        viewModel
                    )
                }
            }
        }
    }
}
