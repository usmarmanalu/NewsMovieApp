package com.dicoding.newsmovieapp.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import coil.compose.*
import com.dicoding.newsmovieapp.R
import com.dicoding.newsmovieapp.ui.theme.*

@Composable
fun MovieItem(
    poster: String,
    title: String,
    year: String,
    runtime: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier

    ) {
        AsyncImage(
            model = poster,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(170.dp)
                .clip(Shapes.medium)
        )
        Text(
            text = title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.ExtraBold
            )
        )
        Text(
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = stringResource(R.string.movie_title, title),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = stringResource(R.string.year, year),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = stringResource(R.string.runtime, runtime),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
@Preview(showBackground = true)
fun RewardItemPreview() {
    NewsMovieAppTheme {
        MovieItem(poster = "", title = "Usmar", year = "64746", runtime = "643")
    }
}