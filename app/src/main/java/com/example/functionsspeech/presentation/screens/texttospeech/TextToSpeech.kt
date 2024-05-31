package com.example.functionsspeech.presentation.screens.texttospeech

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.functionsspeech.presentation.screens.texttospeech.components.AddText
import com.example.functionsspeech.presentation.screens.texttospeech.components.HeaderTtp
import com.example.functionsspeech.presentation.screens.texttospeech.components.Player
import com.example.functionsspeech.presentation.ui.theme.color_five
import com.example.functionsspeech.presentation.ui.theme.color_two

@Composable
fun TextToSpeech(
    viewModel: TextToSpeechViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = color_five)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderTtp()
        AddText(viewModel = viewModel)
        Player(viewModel = viewModel)
    }
    TextTo(viewModel = viewModel)
}

//@Composable
//fun ViewValue(
//    viewModel: TextToSpeechViewModel
//) {
//    val playerEnable: Boolean by viewModel.playerEnable.observeAsState(initial = true)
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(450.dp)
//            .padding(start = 15.dp, end = 15.dp),
//        shape = RoundedCornerShape(20.dp),
//        colors = CardDefaults.cardColors(containerColor = color_two),
//        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
//    ) {
//        if (playerEnable) {
//            AddText(viewModel = viewModel)
//        } else {
//            Player(viewModel = viewModel)
//        }
//    }
//}






