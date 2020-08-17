package com.example.weatherapp.api

// Other imported classes


import com.example.weatherapp.RetroResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataRetriever {
    private val service: WeatherService

    companion object {
        //1
        const val BASE_URL = "https://api.github.com/"
    }

    init {
        // 2
        val retrofit = Retrofit.Builder()
            // 1
            .baseUrl(BASE_URL)
            //3
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //4
        service = retrofit.create(WeatherService::class.java)
    }

    suspend fun getData(): RetroResult {
        return service.searchRepositories()
    }

}
