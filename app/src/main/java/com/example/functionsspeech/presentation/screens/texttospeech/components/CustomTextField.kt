package com.example.functionsspeech.presentation.screens.texttospeech.components

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.functionsspeech.R
import com.example.functionsspeech.presentation.ui.theme.colorBlack
import com.example.functionsspeech.presentation.ui.theme.colorRed

@Composable
fun CustomTextField(
    text: String,
    textInput: (String) -> Unit,
    getSpeech: () -> Unit
) {
    Instruction(text = stringResource(id = R.string.add_text))
    BoxTextField(text = text, textInput = textInput)
    BoxButton(getSpeech = getSpeech)
}

@Composable
fun Instruction(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(top = 10.dp, start = 20.dp),
        fontSize = 20.sp,
        color = colorBlack
    )
}

@Composable
fun BoxTextField(text: String, textInput: (String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(top = 35.dp, start = 40.dp, end = 40.dp)
            .width(400.dp)
            .height(200.dp),
    ) {
        DefaultTextField(
            modifier = Modifier
                .fillMaxSize(), text = text, textInput = textInput
        )
    }
}

@Composable
fun BoxButton(getSpeech: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(top = 35.dp, start = 60.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        DefaultButton(text = stringResource(id = R.string.button_converter), onClick = getSpeech)
        Spacer(modifier = Modifier.width(30.dp))
        DefaultButton(text = stringResource(id = R.string.button_delete), onClick = {})
    }
}

@Composable
fun DefaultTextField(modifier: Modifier = Modifier, text: String, textInput: (String) -> Unit) {
    TextField(
        modifier = modifier,
        value = text,
        onValueChange = {
            textInput.invoke(it)
        },
        colors = TextFieldDefaults.colors(
            cursorColor = colorBlack,
        )
    )
}

@Composable
fun DefaultButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = colorRed),
        onClick = {
            onClick.invoke()
        }
    ) {
        Text(text = text)
    }
}