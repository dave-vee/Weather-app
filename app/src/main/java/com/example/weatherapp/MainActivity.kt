package com.example.weatherapp

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.api.DataRetriever
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    //1 Create a Coroutine scope using a job to be able to cancel when needed
    val mainActivityJob = Job()
    val errorHandler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
        AlertDialog.Builder(this).setTitle("Error")
            .setMessage(exception.message)
            .setPositiveButton(android.R.string.ok) { _, _ -> }
            .setIcon(android.R.drawable.ic_dialog_alert).show()
    }

    //3 the Coroutine runs using the Main (UI) dispatcher
    val coroutineScope = CoroutineScope(mainActivityJob + Dispatchers.Main)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isNetworkConnected()) {
            retrieveData()
        } else {
            AlertDialog.Builder(this).setTitle("No Internet Connection")
                .setMessage("Please check your internet connection and try again")
                .setPositiveButton(android.R.string.ok) { _, _ -> }
                .setIcon(android.R.drawable.ic_dialog_alert).show()
        }


    }


    private fun retrieveData() {
        if (city_name.text.toString().isEmpty()) {
            Toast.makeText(this, "Enter city name", Toast.LENGTH_SHORT).show()
            return
        }
        coroutineScope.launch(errorHandler) {
            //4
            val resultList = DataRetriever().getData(city_name.text.toString())

            val updatedAt = resultList.date
            val temp = resultList.main.temp
            val tempMin = resultList.main.tempMin
            val tempMax = resultList.main.tempMax
            val humidity = resultList.main.humidity
            val sunrise = resultList.sys.sunrise

            val sunset = resultList.sys.sunset
            val weatherDescription = resultList.weather[0].description
            val address = resultList.name + ", " + resultList.sys.country
            val wind = resultList.wind.speed

            /* Populating extracted data into our views */
            findViewById<TextView>(R.id.wind).text = wind.toString()
            findViewById<TextView>(R.id.address).text = address
            findViewById<TextView>(R.id.status).text = weatherDescription
            findViewById<TextView>(R.id.temp).text = temp.toString()
            findViewById<TextView>(R.id.temp_min).text = tempMin.toString()
            findViewById<TextView>(R.id.temp_max).text = tempMax.toString()
            if (sunrise != null) {
                findViewById<TextView>(R.id.sunrise).text =
                    SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunrise * 1000))
            }
            findViewById<TextView>(R.id.sunset).text =
                SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunset * 1000))

            findViewById<TextView>(R.id.humidity).text = humidity.toString()

            findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
            findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.VISIBLE
            findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE


        }


    }

    private fun isNetworkConnected(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    fun refreshData(view: View) {

        retrieveData()

    }

}