package com.example.weatherapp.models

//data class RetroResult(val dataInputStream: DataInputStream)
data class Response(
    var date: Double?,
    var name: String?,
    var sys: Sys,
    var main: Main,
    var weather: ArrayList<Weather>,
    var address: String?,
    val wind: Wind

)

data class Wind(
    val speed: Double,
    val deg: Int
)

data class Weather(
    val description: String,
)

data class Sys(
    val country: String,
    var sunrise: Long,
    var sunset: Long
)

data class Main(
    val temp: Double,
    var humidity: Long,
    var temp_min: Double,
    var temp_max: Double,

    )