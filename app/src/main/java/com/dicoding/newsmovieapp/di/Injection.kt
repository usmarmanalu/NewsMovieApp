package com.dicoding.newsmovieapp.di

import android.content.Context
import com.dicoding.newsmovieapp.data.*
import com.dicoding.newsmovieapp.local.room.*

object Injection {
    fun provideRepository(context: Context): MovieRepository {
        val db = FavoriteMovieDatabase.getDatabase(context)
        val dao = db.dao()
        return MovieRepository.getInstance(dao)
    }
}