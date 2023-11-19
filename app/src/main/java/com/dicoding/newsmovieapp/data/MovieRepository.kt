package com.dicoding.newsmovieapp.data

import com.dicoding.newsmovieapp.data.fake.*
import com.dicoding.newsmovieapp.local.room.*
import kotlinx.coroutines.flow.*

class MovieRepository(private val movieFavoriteDao: MovieFavoriteDao) {

    private val movie = mutableListOf<Movie>()

    init {
        if (movie.isEmpty()) {
            movie.addAll(MovieData.dummyMovie)
        }
    }

    fun getMovie(): List<Movie> {
        return movie.toList()
    }

    fun searchMovieId(query: String): List<Movie> {
        return movie.filter {
            it.title.contains(query, ignoreCase = true)
        }
    }

    fun getAllMovie(): Flow<List<Movie>> {
        return flowOf(movie)
    }

    fun getMovieId(movieId: Long): Movie {
        return movie.first {
            it.id == movieId
        }
    }

    suspend fun saveFavoriteMovie(movie: Movie) {
        movieFavoriteDao.insert(movie)
    }

    suspend fun delete(movie: Movie) {
        movieFavoriteDao.delete(movie)
    }

    suspend fun getFavoriteMovie(): List<Movie> {
        return movieFavoriteDao.getAllFavUser()
    }

    suspend fun isFavorite(id: Long): Boolean = movieFavoriteDao.isFavoriteMovie(id)

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(movieFavoriteDao: MovieFavoriteDao): MovieRepository =
            instance ?: synchronized(this) {
                MovieRepository(movieFavoriteDao).apply {
                    instance = this
                }
            }
    }
}

