package com.example.weatherapp.api


import com.example.weatherapp.RetroResult
import retrofit2.http.GET

interface WeatherService {

    @GET("/weather")
    suspend fun retrieveData(): RetroResult

    //sample search
//    @GET("/search/weather/?q=$city&units=metric&appid=$api")
    suspend fun searchData(): RetroResult

}