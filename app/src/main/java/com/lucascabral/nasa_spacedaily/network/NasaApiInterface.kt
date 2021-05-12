package com.lucascabral.nasa_spacedaily.network

import retrofit2.http.GET

const val API_KEY = "L99iBvsec6MjC2d1rFb02P8HzxZcEsIRhududhyf"

interface NasaApiInterface {
    @GET("apod?api_key=$API_KEY")
    suspend fun getDailyPhoto(): PhotoResponse
}