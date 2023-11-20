package com.dicoding.newsmovieapp.ui.screen.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.*
import com.dicoding.newsmovieapp.*
import com.dicoding.newsmovieapp.data.*
import com.dicoding.newsmovieapp.data.fake.*
import com.dicoding.newsmovieapp.di.*
import com.dicoding.newsmovieapp.ui.component.*

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    ),
    navigateToDetail: (Long) -> Unit,
) {
    val filtered by viewModel.filterMovie.collectAsState()
    val query by viewModel.query

    viewModel.uiState.collectAsState(initial = ResultState.Loading).value.let { uiState ->
        when (uiState) {
            is ResultState.Loading -> {
                viewModel.getAllMovie()
            }

            is ResultState.Success -> {
                Column {
                    Box(modifier = modifier) {
                        Banner()
                        SearchBar(query = query, onQueryChange = viewModel::searchMovie)
                    }
                    HomeContent(
                        movie = filtered,
                        navigateToDetail = navigateToDetail,
                    )
                }
            }

            is ResultState.Error -> {

            }
        }
    }
}

@Composable
fun HomeContent(
    movie: List<Movie>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.testTag("MovieList")
    ) {
        items(movie) { data ->
            MovieItem(
                poster = data.posterUrl,
                title = data.title,
                year = data.year,
                runtime = data.runtime,
                modifier = Modifier.clickable {
                    navigateToDetail(data.id)
                }
            )
        }
    }
}


