package com.example.weatherapp.services



import com.example.weatherapp.data.Response
import retrofit2.http.GET

import retrofit2.http.Query

interface WeatherService {


    //sample search
    @GET("data/2.5/weather/")
    suspend fun searchData(
        @Query("q") city: String,
        @Query("appid") appId: String
    ): Response

}