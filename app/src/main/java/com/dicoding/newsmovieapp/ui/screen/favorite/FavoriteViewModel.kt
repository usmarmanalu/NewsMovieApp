package com.dicoding.newsmovieapp.ui.screen.favorite

import androidx.lifecycle.*
import com.dicoding.newsmovieapp.data.*
import com.dicoding.newsmovieapp.data.fake.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class FavoriteViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _uiSate: MutableStateFlow<ResultState<List<Movie>>> =
        MutableStateFlow((ResultState.Loading))

    val uiState: StateFlow<ResultState<List<Movie>>> get() = _uiSate


    fun getFavoriteMovie() {
        viewModelScope.launch {
            _uiSate.value = ResultState.Loading
            _uiSate.value = ResultState.Success(repository.getFavoriteMovie().sortedBy { it.title })
        }
    }
}