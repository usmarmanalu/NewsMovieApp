package com.dicoding.newsmovieapp.ui.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.*
import com.dicoding.newsmovieapp.R

@Composable
fun Banner() {
    AnimatedBanner()
}

@Composable
fun AnimatedBanner() {
    val imageList = listOf(
        R.drawable.banner,
        R.drawable.banner2,
        R.drawable.banner3,
        R.drawable.banner4,
        R.drawable.banner5,
        R.drawable.banner6,
    )

    val transition = rememberInfiniteTransition(label = "")

    val currentImage by transition.animateFloat(
        initialValue = 0f,
        targetValue = imageList.size.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 8000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "",
    )

    Image(
        painter = painterResource(id = imageList[currentImage.toInt()]),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.height(160.dp)
    )
}
