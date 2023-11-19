package com.dicoding.newsmovieapp.ui.screen.home

import androidx.compose.runtime.*
import androidx.lifecycle.*
import com.dicoding.newsmovieapp.data.*
import com.dicoding.newsmovieapp.data.fake.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class HomeViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<ResultState<List<Movie>>> = MutableStateFlow(ResultState.Loading)
    val uiState: StateFlow<ResultState<List<Movie>>>
        get() = _uiState

    private val _filterMovie = MutableStateFlow(
        repository.getMovie().sortedBy { it.title }
    )

    val filterMovie: StateFlow<List<Movie>> get() = _filterMovie

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun searchMovie(newQuery: String) {
        _query.value = newQuery
        _filterMovie.value = repository.searchMovieId(_query.value)
            .sortedBy { it.title }
    }

    fun getAllMovie() {
        viewModelScope.launch {
            repository.getAllMovie()
                .catch {
                    _uiState.value = ResultState.Error(it.message.toString())
                }
                .collect { orderRewards ->
                    _uiState.value = ResultState.Success(orderRewards)
                }
        }
    }
}