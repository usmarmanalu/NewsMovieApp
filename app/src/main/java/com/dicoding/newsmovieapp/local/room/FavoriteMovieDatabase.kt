package com.dicoding.newsmovieapp.local.room

import android.content.*
import androidx.room.*
import com.dicoding.newsmovieapp.data.fake.*

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class FavoriteMovieDatabase : RoomDatabase() {

    abstract fun dao(): MovieFavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: FavoriteMovieDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): FavoriteMovieDatabase {
            if (INSTANCE == null) {
                synchronized(FavoriteMovieDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        FavoriteMovieDatabase::class.java, "movie_database"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE as FavoriteMovieDatabase
        }
    }
}
