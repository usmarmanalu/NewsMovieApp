package com.dicoding.newsmovieapp.ui.screen.detail

import androidx.lifecycle.*
import com.dicoding.newsmovieapp.data.*
import com.dicoding.newsmovieapp.data.fake.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class DetailViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<ResultState<Movie>> =
        MutableStateFlow(ResultState.Loading)
    val uiState: StateFlow<ResultState<Movie>> get() = _uiState

    private val _isMovieSaved = MutableStateFlow(false)
    val isMovieSaved: StateFlow<Boolean> get() = _isMovieSaved

    fun getMovieId(movieId: Long) {
        viewModelScope.launch {
            try {
                _uiState.value = ResultState.Loading
                val movie = repository.getMovieId(movieId)
                _uiState.value = ResultState.Success(movie)
            } catch (e: Exception) {
                _uiState.value = ResultState.Error(e.message ?: "An error occurred")
            }
        }
    }

    fun isFavoriteMovie(movieId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _isMovieSaved.value = repository.isFavorite(movieId)
        }
    }

    fun saveFavoriteMovie(favoriteMovie: Movie) {
        _isMovieSaved.value = true
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveFavoriteMovie(favoriteMovie)
        }
    }

    fun deleteFavoriteMovie(favoriteMovie: Movie): Job {
        _isMovieSaved.value = false
        return viewModelScope.launch(Dispatchers.IO) {
            repository.delete(favoriteMovie)
        }
    }

    override fun onCleared() {
        super.onCleared()
        // Cancel ongoing coroutines when the ViewModel is cleared
        viewModelScope.cancel()
    }
}
