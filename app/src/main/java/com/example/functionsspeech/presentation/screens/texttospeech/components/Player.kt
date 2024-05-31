package com.example.functionsspeech.presentation.screens.texttospeech.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.functionsspeech.R
import com.example.functionsspeech.presentation.screens.texttospeech.TextToSpeechViewModel
import com.example.functionsspeech.presentation.ui.theme.color_one
import com.example.functionsspeech.presentation.ui.theme.color_seven
import com.example.functionsspeech.presentation.ui.theme.color_three

@Composable
fun Player(viewModel: TextToSpeechViewModel) {
    val btnPlay: Boolean by viewModel.btnPlay.observeAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .width(325.dp)
                .height(250.dp)
                .padding(top = 50.dp, start = 10.dp, end = 10.dp),
            colors = CardDefaults.cardColors(containerColor = color_seven)
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_diamon),
                contentDescription = "Audio",
                modifier = Modifier
                    .padding(top = 40.dp, start = 100.dp)
            )
        }
        Box(
            modifier = Modifier
                .padding(start = 30.dp, top = 30.dp, end = 30.dp)
                .width(250.dp)
                .height(4.dp)
                .background(color_one)
        )
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = color_three),
                onClick = { /*TODO*/ }
            ) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Button menu")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = color_three),
                onClick = {
                    if (btnPlay) {
                        viewModel.onButtonPlay(false)
                        viewModel.playPauseSound()
                    } else {
                        viewModel.onButtonPlay(true)
                        viewModel.playPauseSound()
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Button play"
                )
            }
        }
    }
}