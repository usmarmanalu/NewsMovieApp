package com.dicoding.newsmovieapp.ui.screen.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import com.dicoding.newsmovieapp.R
import com.dicoding.newsmovieapp.ui.component.*
import com.dicoding.newsmovieapp.ui.theme.*

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(400.dp)
                    .clip(Shapes.large)
                    .padding(8.dp)
            )
            HeightSpacer(16.dp)
            Text(
                text = stringResource(id = R.string.name),
                style = Typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            HeightSpacer(8.dp)
            Text(
                text = stringResource(id = R.string.email),
                style = Typography.bodyMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    NewsMovieAppTheme {
        ProfileScreen()
    }
}
