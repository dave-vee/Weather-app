package com.example.weatherapp

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.weatherapp.api.DataRetriever
import com.example.weatherapp.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var alertDialog: MaterialAlertDialogBuilder

    // Create a Coroutine scope using a job to be able to cancel when needed
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        if (isNetworkConnected()) {
            retrieveData()
        } else {

            AlertDialog.Builder(this).setTitle("No Internet Connection")
                .setMessage("Please check your internet connection and try again")
                .setPositiveButton(android.R.string.ok) { _, _ -> }
                .setIcon(android.R.drawable.ic_dialog_alert).show()
        }
        binding.refresh.setOnClickListener {
            retrieveData()
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


            val temp = resultList.main.temp
            val tempMin = resultList.main.temp_min
            val tempMax = resultList.main.temp_max
            val humidity = resultList.main.humidity
            val sunrise = resultList.sys.sunrise

            val sunset = resultList.sys.sunset
            val weatherDescription = resultList.weather[0].description
            val address = resultList.name + ", " + resultList.sys.country
            val wind = resultList.wind.speed

            val temp1 = temp - 273
            val temp_max1 = tempMax - 273
            val temp_min1 = tempMin - 273


            /* Populating extracted data into our views */

            binding.loader.visibility = View.GONE
            binding.mainContainer.visibility = View.VISIBLE
            binding.humidity.text = humidity.toString()
            binding.wind.text = wind.toString()
            binding.address.text = address
            binding.status.text = weatherDescription
            binding.temp.text = temp1.toInt().toString() + "°C"
            binding.tempMax.text = " Min Temp :" + temp_min1.toInt().toString() + "°C"
            binding.tempMin.text = "Max Temp :" + temp_max1.toInt().toString() + "°C"
            binding.sunset.text =
                SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunset * 1000))
            binding.sunrise.text =
                SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunrise * 1000))

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


}