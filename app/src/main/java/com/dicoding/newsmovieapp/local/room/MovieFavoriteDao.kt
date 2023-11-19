package com.dicoding.newsmovieapp.local.room

import androidx.room.*
import com.dicoding.newsmovieapp.data.fake.*


@Dao
interface MovieFavoriteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favoriteMovie: Movie)

    @Delete
    suspend fun delete(favoriteUser: Movie)

    @Query("SELECT * from Movie")
    suspend fun getAllFavUser(): List<Movie>

    @Query("SELECT EXISTS (SELECT 1 FROM Movie WHERE MOVIE.id =  :movieId)")
    suspend fun isFavoriteMovie(movieId: Long): Boolean
}