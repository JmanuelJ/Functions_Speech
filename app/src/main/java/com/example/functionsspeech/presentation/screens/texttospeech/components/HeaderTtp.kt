package com.example.functionsspeech.presentation.screens.texttospeech.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.functionsspeech.R
import com.example.functionsspeech.presentation.ui.theme.colorGradientRb
import com.example.functionsspeech.presentation.ui.theme.colorWithe

@Composable
fun HeaderTtp() {
    ConstraintLayout {
        val (box, title) = createRefs()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(
                    brush = colorGradientRb,
                    shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)
                )
                .constrainAs(box) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
        Text(
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            text = stringResource(id = R.string.title_text_to_speech),
            fontSize = 25.sp,
            color = colorWithe,
            fontWeight = FontWeight.Bold
        )
    }
}