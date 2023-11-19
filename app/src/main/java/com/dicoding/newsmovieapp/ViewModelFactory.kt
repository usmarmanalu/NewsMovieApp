package com.dicoding.newsmovieapp

import androidx.lifecycle.*
import com.dicoding.newsmovieapp.data.*
import com.dicoding.newsmovieapp.ui.screen.detail.*
import com.dicoding.newsmovieapp.ui.screen.favorite.*
import com.dicoding.newsmovieapp.ui.screen.home.*


class ViewModelFactory(private val repository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
            return FavoriteViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}