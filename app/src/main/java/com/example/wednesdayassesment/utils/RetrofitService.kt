package com.example.wednesdayassesment.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    companion object{
        private val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        fun createService():RetrofitApi=retrofitBuilder.create(RetrofitApi::class.java)
    }
}