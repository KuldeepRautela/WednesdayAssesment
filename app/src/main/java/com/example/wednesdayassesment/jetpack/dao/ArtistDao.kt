package com.example.wednesdayassesment.jetpack.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.wednesdayassesment.jetpack.model.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArtistData(data:List<Artist>)
    @Query("select * from Artist where artistName =:name")
    fun getArtistData(name:String):LiveData<List<Artist>>
}