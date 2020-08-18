package com.example.weatherapp

//data class RetroResult(val dataInputStream: DataInputStream)
data class Response(
    var date: Double?,
    var name: String?,
    var country: String?,
    var temp: Long?,
    var tempMin: String,
    var tempMax: String,
    var humidity: Long?,
    var sunrise: String?,
    var sunset: String,
    var description: String,
    var address: String?

)

