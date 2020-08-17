package com.example.weatherapp

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.api.DataRetriever
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Switch to AppTheme for displaying the activity
        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isNetworkConnected()) {
            retrieveRepositories()
        } else {
            AlertDialog.Builder(this).setTitle("No Internet Connection")
                .setMessage("Please check your internet connection and try again")
                .setPositiveButton(android.R.string.ok) { _, _ -> }
                .setIcon(android.R.drawable.ic_dialog_alert).show()
        }
    }

    fun retrieveRepositories() {
        //1 Create a Coroutine scope using a job to be able to cancel when needed
        val mainActivityJob = Job()

        //2 Handle exceptions if any
        val errorHandler = CoroutineExceptionHandler { _, exception ->
            AlertDialog.Builder(this).setTitle("Error")
                .setMessage(exception.message)
                .setPositiveButton(android.R.string.ok) { _, _ -> }
                .setIcon(android.R.drawable.ic_dialog_alert).show()
        }

        //3 the Coroutine runs using the Main (UI) dispatcher
        val coroutineScope = CoroutineScope(mainActivityJob + Dispatchers.Main)
        coroutineScope.launch(errorHandler) {
            //4
            val resultList = DataRetriever().getData()

        }


    }

    fun isNetworkConnected(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

}
//    inner class WeatherTask() {


//        val temp = temp.getDouble("temp" + "°C")
//        val tempMin = "Min Temp: " + tempMin.getString("temp_min") + "°C"
//       val tempMax = "Max Temp: " + tempMax.getString("temp_max") + "°C"
//       val humidity = Response.humidity.getString("humidity")
//        val sunrise: Long = sunris.getLong("sunrise")
//        val sunset: Long = sunse.getLong("sunset")
//       val weatherDescription = describe.getString("description")
//       val address = name.getString("name") + ", " + country.getString()
//
//        /* Populating extracted data into our views */
//       findViewById<TextView>(R.id.address).text = address.toString()
//       findViewById<TextView>(R.id.updated_at).text = updatedAtText
//       findViewById<TextView>(R.id.status).text = weatherDescription.capitalize()
//       findViewById<TextView>(R.id.temp).text = temp.toString()
//       findViewById<TextView>(R.id.temp_min).text = tempMin
//       findViewById<TextView>(R.id.temp_max).text = tempMax
//        findViewById<TextView>(R.id.sunrise).text =
//        SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunrise * 1000))
//        findViewById<TextView>(R.id.sunset).text =
//        SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunset * 1000))
//
//        findViewById<TextView>(R.id.humidity).text = humidity
//
//       /* Views populated, Hiding the loader, Showing the main design */
//        findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
//       findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.VISIBLE
//     }

//        override fun onPreExecute() {
//            super.onPreExecute()
//            /* Showing the ProgressBar, Making the main design GONE */
//            findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
//            findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.GONE
//            findViewById<TextView>(R.id.errorText).visibility = View.GONE
//        }

//        override fun doInBackground(vararg params: String?): String? {
//            var response: String?
//            try {
//                response =
//                    URL("https://api.openweathermap.org/data/2.5/weather?q=$city&units=metric&appid=$url").readText(
//                        Charsets.UTF_8
//                    )
//            } catch (e: Exception) {
//                response = null
//            }
//            return response
//        }

//        override fun onPostExecute(result: String?) {
//            super.onPostExecute(result)
//            try {
//                /* Extracting JSON returns from the API */

//                val jsonObj = JSONObject(result)
//                val tempr = jsonObj.getJSONObject("temp")
//                val country = jsonObj.getJSONObject("country")
//                val tempMini = jsonObj.getJSONObject("tempMin")
//                val tempMaxi = jsonObj.getJSONObject("tempMax")
//                val humid = jsonObj.getJSONObject("humidity")
//                val sunris = jsonObj.getJSONObject("sunrise")
//                val sunse = jsonObj.getJSONObject("country")
//                val describe = jsonObj.getJSONObject("description")
//                val name = weather.getJSONObject("name")

//               val wind = jsonObj.getJSONObject("wind")
//               val weather = jsonObj.getJSONArray("weather").getJSONObject(0)
//               val updatedAt: Long = jsonObj.getLong("dt")


//                var weather = Gson().fromJson(result, Weather::class.java)
//                val updatedAtText =
//                    "Updated at: " + SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(
//                        Date(weather.dt!! * 1000)
//                    )
//                val temp = weather.temp.getDouble("temp" + "°C")
//                val tempMin = "Min Temp: " + tempMini.getString("temp_min") + "°C"
//                val tempMax = "Max Temp: " + tempMaxi.getString("temp_max") + "°C"
//                val humidity = humid.getString("humidity")
//                val sunrise: Long = sunris.getLong("sunrise")
//                val sunset: Long = sunse.getLong("sunset")
//                val weatherDescription = describe.getString("description")
//                val address = name.getString("name") + ", " + country.getString("country")
//
//                /* Populating extracted data into our views */
//                findViewById<TextView>(R.id.address).text = address.toString()
//                findViewById<TextView>(R.id.updated_at).text = updatedAtText
//                findViewById<TextView>(R.id.status).text = weatherDescription.capitalize()
//                findViewById<TextView>(R.id.temp).text = temp.toString()
//                findViewById<TextView>(R.id.temp_min).text = tempMin
//                findViewById<TextView>(R.id.temp_max).text = tempMax
//                findViewById<TextView>(R.id.sunrise).text =
//                    SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunrise * 1000))
//                findViewById<TextView>(R.id.sunset).text =
//                    SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunset * 1000))
//
//                findViewById<TextView>(R.id.humidity).text = humidity
//
//                /* Views populated, Hiding the loader, Showing the main design */
//                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
//                findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.VISIBLE

//            } catch (e: Exception) {
//                findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
//                findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
//            }
//
//        }
//    }


