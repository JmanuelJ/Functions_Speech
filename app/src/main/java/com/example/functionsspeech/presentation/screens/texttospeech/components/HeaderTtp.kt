package com.example.functionsspeech.presentation.screens.texttospeech.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.functionsspeech.R
import com.example.functionsspeech.presentation.ui.theme.color_eight
import com.example.functionsspeech.presentation.ui.theme.color_one

@Composable
fun HeaderTtp() {
    ConstraintLayout {
        val (box, btn, logo, title) = createRefs()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(
                    brush = color_eight,
                    shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)
                )
                .constrainAs(box) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Arrow Back",
            modifier = Modifier
                .constrainAs(btn) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .padding(top = 10.dp, start = 15.dp),
            tint = color_one
        )
        Image(
            painter = painterResource(id = R.mipmap.ic_diane_name_white),
            contentDescription = "logo",
            modifier = Modifier
                .constrainAs(logo) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                },
            alignment = Alignment.CenterEnd,
            contentScale = ContentScale.Crop
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
            color = color_one,
            fontWeight = FontWeight.Bold
        )
    }
}