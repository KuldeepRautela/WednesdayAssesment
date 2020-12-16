package com.example.wednesdayassesment.jetpack.model
import com.google.gson.annotations.SerializedName

data class ArtistData(
    @SerializedName("results")
     val dataList:List<Artist>
)