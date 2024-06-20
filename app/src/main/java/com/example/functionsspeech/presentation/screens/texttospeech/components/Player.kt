package com.example.functionsspeech.presentation.screens.texttospeech.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.functionsspeech.R
import com.example.functionsspeech.presentation.ui.theme.Purple80
import com.example.functionsspeech.presentation.ui.theme.colorRed

@Composable
fun Player(onPlayPause: () -> Unit, onReset: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImagePlayer(
            modifier = Modifier
                .width(325.dp)
                .height(250.dp)
                .padding(top = 50.dp, start = 8.dp, end = 8.dp)
        )
        ButtonsPlayer(onPlayPause = onPlayPause)
        Button(onClick = {
            onReset.invoke()
        }) {
            Text(text = "Regresar")
        }
    }
}

@Composable
fun ImagePlayer(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Purple80)
    ) {
        Image(
            painter = painterResource(id = R.mipmap.ic_diamon),
            contentDescription = "Audio",
            modifier = Modifier
                .padding(top = 40.dp, start = 100.dp)
        )
    }
}

@Composable
fun ButtonsPlayer(onPlayPause: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ButtonBox(
            image = Icons.Default.Add,
            description = "Button save",
            name = "Guardar",
            onClick = {}
        )
        Spacer(modifier = Modifier.width(20.dp))
        ButtonBox(
            image = Icons.Default.PlayArrow,
            description = "Button play-pause",
            name = "Play/Pause",
            onClick = {
                onPlayPause.invoke()
            }
        )
    }
}

@Composable
fun ButtonBox(image: ImageVector, description: String, name: String, onClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        DefaultIconButton(
            image = image,
            description = description,
            onClick = onClick
        )
        Text(
            text = name,
            fontSize = 16.sp
        )
    }
}

@Composable
fun DefaultIconButton(image: ImageVector, description: String, onClick: () -> Unit) {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = colorRed),
        onClick = {
            onClick.invoke()
        }
    ) {
        Icon(imageVector = image, contentDescription = description)
    }
}