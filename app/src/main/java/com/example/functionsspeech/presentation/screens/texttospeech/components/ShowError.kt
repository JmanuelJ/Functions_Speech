package com.example.functionsspeech.presentation.screens.texttospeech.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun ShowError(errorMessage: String) {
    Toast.makeText(
        LocalContext.current,
        "Error: $errorMessage",
        Toast.LENGTH_SHORT
    ).show()
}