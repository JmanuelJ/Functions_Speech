package com.example.functionsspeech.presentation.screens.texttospeech.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.functionsspeech.R
import com.example.functionsspeech.presentation.screens.texttospeech.TextToSpeechViewModel
import com.example.functionsspeech.presentation.ui.theme.color_one
import com.example.functionsspeech.presentation.ui.theme.color_three
import com.example.functionsspeech.presentation.ui.theme.color_two

@Composable
fun AddText(viewModel: TextToSpeechViewModel) {
    val text: String by viewModel.text.observeAsState(initial = "")

    Text(
        text = stringResource(id = R.string.add_text),
        modifier = Modifier.padding(top = 10.dp, start = 20.dp),
        fontSize = 20.sp,
        color = color_one
    )
    Card(
        modifier = Modifier
            .padding(top = 35.dp, start = 40.dp, end = 40.dp)
            .width(400.dp)
            .height(200.dp),
    ) {
        TextField(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.Transparent
                ),
            value = text,
            onValueChange = {
                viewModel.onTexInput(it)
            },
            colors = TextFieldDefaults.colors(
                cursorColor = color_two,
            )
        )
    }
    Row(
        modifier = Modifier
            .padding(top = 35.dp, start = 60.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = color_three),
            onClick = {
                viewModel.getSpeech()

            }
        ) {
            Text(text = stringResource(id = R.string.button_converter))
        }

        Spacer(modifier = Modifier.width(30.dp))

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = color_three),
            onClick = { /*TODO*/ }
        ) {
            Text(text = stringResource(id = R.string.button_delete))
        }
    }
}