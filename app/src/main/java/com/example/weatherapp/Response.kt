package com.example.weatherapp

import android.content.ClipData

data class RetroResult(val items: List<ClipData.Item>)
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
    var description: Boolean,
    var address: String?

)

