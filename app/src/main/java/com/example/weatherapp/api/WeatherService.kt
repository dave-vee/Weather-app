package com.example.weatherapp.api


import com.example.weatherapp.RetroResult
import retrofit2.http.GET

interface WeatherService {

    @GET("/repositories")
    suspend fun retrieveRepositories(): RetroResult

    //sample search
    @GET("/search/repositories?q=language:kotlin&sort=stars&order=desc&per_page=50")
    suspend fun searchRepositories(): RetroResult

}