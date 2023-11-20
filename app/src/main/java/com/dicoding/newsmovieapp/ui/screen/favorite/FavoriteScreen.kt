package com.dicoding.newsmovieapp.ui.screen.favorite

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.*
import com.dicoding.newsmovieapp.*
import com.dicoding.newsmovieapp.data.*
import com.dicoding.newsmovieapp.di.*
import com.dicoding.newsmovieapp.ui.component.*


@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoriteViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(LocalContext.current)
        )
    ),
) {

    viewModel.uiState.collectAsState(initial = ResultState.Loading).value.let { uiState ->
        when (uiState) {
            is ResultState.Loading -> {
                viewModel.getFavoriteMovie()
            }

            is ResultState.Success -> {
                val data = (uiState).data
                Column {
                    Banner()
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(160.dp),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = modifier.testTag("MovieList")
                    ) {
                        items(data) { movie ->
                            MovieItem(
                                poster = movie.posterUrl,
                                title = movie.title,
                                year = movie.year,
                                runtime = movie.runtime,
                            )
                        }
                    }
                }
            }

            is ResultState.Error -> {}
        }
    }
}