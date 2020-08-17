package com.example.weatherapp

import com.google.gson.Gson
import java.net.URL

class Request {


    companion object {

        var city: String = "Nairobi , KE"
        val api = "d845d2e9037d492993a7d145294827b6" // Use your own API key fro Open weather


        //1
        private const val URL = "https://api.openweathermap.org/data/2.5/weather"
        val SEARCH = " ?q=$city&units=metric&appid=$api "
        val COMPLETE_URL = "$URL?$SEARCH"
        val newResponse = run()

        //2
        fun run(): Response { //2
            val response = URL(COMPLETE_URL).readText(Charsets.UTF_8)

            return Gson().fromJson(response, Response::class.java) //4

        }

    }
}