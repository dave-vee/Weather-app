package com.example.weatherApp.ui

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherApp.R
import com.example.weatherApp.services.OpenWeather
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.coroutines.*

class ActivitySearch : AppCompatActivity() {


    private val mainActivityJob = Job()
    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
        AlertDialog.Builder(this).setTitle("Error")
            .setMessage(exception.message)
            .setPositiveButton(android.R.string.ok) { _, _ -> }
            .setIcon(android.R.drawable.ic_dialog_alert).show()
    }

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(mainActivityJob + Dispatchers.Main)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)



        btn_search.setOnClickListener {
            if (isNetworkAvailable()) {
                retrieveData()
            } else {
                AlertDialog.Builder(this).setTitle("No Internet Connection")
                    .setMessage("Please check your internet connection and try again")
                    .setPositiveButton(android.R.string.ok) { _, _ -> }
                    .setIcon(android.R.drawable.ic_dialog_alert).show()
            }

        }


    }


    private fun retrieveData() {
        if (input_edit_text?.text.toString().isEmpty()) {
            Toast.makeText(this, "Enter city Name", Toast.LENGTH_SHORT).show()

        }
        coroutineScope.launch(errorHandler) {

            val resultList = OpenWeather().getData(input_edit_text.text.toString())


            val temp = resultList.main.temp
            val temp1 = temp - 273
            val humidity = resultList.main.humidity
            val weatherDescription = resultList.weather[0].description
            val address = resultList.name + ", " + resultList.sys.country
            val wind = resultList.wind.speed


            /* Populating extracted data into our views */
            w_address.text = address.toString()
            weather_description?.text = weatherDescription
            w_temperature?.text = temp1.toInt().toString() + "°C"
            w_humidity.text = "$humidity%"
            w_wind?.text = wind.toString() + "Km/h"


        }


    }


    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE)
        return if (connectivityManager is ConnectivityManager) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected ?: false
        } else false
    }


}