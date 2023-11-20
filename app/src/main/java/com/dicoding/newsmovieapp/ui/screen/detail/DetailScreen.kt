package com.dicoding.newsmovieapp.ui.screen.detail

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.*
import coil.compose.*
import com.dicoding.newsmovieapp.*
import com.dicoding.newsmovieapp.R
import com.dicoding.newsmovieapp.data.*
import com.dicoding.newsmovieapp.di.*
import com.dicoding.newsmovieapp.ui.component.*
import com.dicoding.newsmovieapp.ui.theme.*

@Composable
fun DetailScreen(
    movieId: Long,
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(LocalContext.current)
        )
    ),
    navigateBack: () -> Unit,

    ) {
    val uiState by viewModel.uiState.collectAsState()
    val isMovieSaved by viewModel.isMovieSaved.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(movieId) {
        viewModel.getMovieId(movieId)
        viewModel.isFavoriteMovie(movieId)
    }

    when (val resultState = uiState) {
        is ResultState.Loading -> {
            viewModel.getMovieId(movieId)
            viewModel.isFavoriteMovie(movieId)
        }

        is ResultState.Success -> {
            val data = resultState.data
            DetailContent(
                title = data.title,
                year = data.year,
                runtime = data.runtime,
                posterUrl = data.posterUrl,
                isMovieSaved,
                setFavorite = {
                    if (viewModel.isMovieSaved.value) {
                        viewModel.deleteFavoriteMovie(data)
                        Toast.makeText(context, context.resources.getString(R.string.gagal), Toast.LENGTH_SHORT).show()

                    } else {
                        viewModel.saveFavoriteMovie(data)
                        Toast.makeText(context, context.resources.getString(R.string.sukses), Toast.LENGTH_SHORT).show()
                    }
                },
                onBackClick = navigateBack
            )
        }

        is ResultState.Error -> {
        }
    }
}

@Composable
fun DetailContent(
    title: String,
    year: String,
    runtime: String,
    posterUrl: String,
    isMovieSaved: Boolean,
    setFavorite: () -> Unit,
    onBackClick: () -> Unit
) {
    Column {
        CustomToAppBar(title = stringResource(R.string.data_movie), onBackClick = onBackClick)

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                IconButton(onClick = setFavorite, modifier = Modifier.align(Alignment.CenterEnd)) {
                    Icon(
                        painter = painterResource(
                            id = if (isMovieSaved) R.drawable.baseline_favorite_24
                            else R.drawable.baseline_favorite_border_24
                        ),
                        tint = if (isMovieSaved) Color.Blue else Color.Blue,
                        contentDescription = stringResource(R.string.favorite_button)
                    )
                }
                Text(
                    fontSize = 24.sp,
                    text = title,
                    modifier = Modifier.align(Alignment.Center),
                    style = Typography.titleLarge.copy(Color.Magenta)
                )
            }

            HeightSpacer(height = 8.dp)
            AsyncImage(
                contentScale = ContentScale.Crop,
                model = posterUrl, contentDescription = title,
                modifier = Modifier
                    .size(500.dp)
                    .align(Alignment.CenterHorizontally)
            )
            HeightSpacer(height = 16.dp)
            Text(
                text = stringResource(id = R.string.movie_title, title),
                style = Typography.titleMedium.copy(color = Color.Black)
            )

            HeightSpacer(height = 8.dp)
            Text(
                text = stringResource(id = R.string.year, year),
                style = Typography.bodyLarge
            )
            HeightSpacer(height = 8.dp)
            Text(
                text = stringResource(id = R.string.runtime, runtime),
                style = Typography.bodyLarge
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DetailPreview() {
    NewsMovieAppTheme {
        DetailScreen(movieId = 1, navigateBack = {})
    }
}