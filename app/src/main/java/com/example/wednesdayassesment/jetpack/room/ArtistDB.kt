package com.example.wednesdayassesment.jetpack.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.wednesdayassesment.jetpack.dao.ArtistDao
import com.example.wednesdayassesment.jetpack.model.Artist
import com.example.wednesdayassesment.ui.activities.MainActivity

@Database(entities = [Artist::class], version = 1)
abstract class ArtistDB : RoomDatabase() {
    companion object {
        private var artistDB: ArtistDB? = null
        @Synchronized
        fun getInstance(): ArtistDB? {
            if (artistDB == null)
                artistDB = Room.databaseBuilder(MainActivity.context, ArtistDB::class.java, "ArtistDB").fallbackToDestructiveMigration().build()
            return artistDB
        }
    }
    abstract fun artistDao():ArtistDao
}