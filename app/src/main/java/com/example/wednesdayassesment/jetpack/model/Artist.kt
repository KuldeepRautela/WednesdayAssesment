package com.example.wednesdayassesment.jetpack.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Artist")
data class Artist(
    @PrimaryKey
    val trackId: Int,
    val artistName: String? = null,
    @SerializedName("collectionName")
    val albumn: String? = null,
    val trackName: String,
    @SerializedName("artworkUrl100")
    val songImg: String? = null,
    @SerializedName("primaryGenreName")
    val genreName: String? = null
)