package com.lucascabral.nasa_spacedaily.network

import retrofit2.http.GET

const val API_KEY = YOUR_API_KEY

interface NasaApiInterface {
    @GET("apod?api_key=$API_KEY")
    suspend fun getDailyPhoto(): PhotoResponse
}
