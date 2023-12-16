package com.kenzietaqiyassar.mandirinewsapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    companion object {
        fun getClient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }


}