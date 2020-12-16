package com.example.wednesdayassesment.utils

import com.example.wednesdayassesment.jetpack.model.ArtistData
import com.example.wednesdayassesment.jetpack.room.ArtistDB
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {
    @GET("search")
     fun getArtistData(@Query("term") term:String): Call<ArtistData>
}