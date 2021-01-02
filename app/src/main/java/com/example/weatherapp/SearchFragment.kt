package com.example.weatherapp

import android.app.AlertDialog
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.weatherapp.services.OpenWeather
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.coroutines.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {

    private var viewBinding: SearchFragment? = null


    // Create a Coroutine scope using a job to be able to cancel when needed
    private val mainActivityJob = Job()
    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
        AlertDialog.Builder(activity).setTitle("Error")
            .setMessage(exception.message)
            .setPositiveButton(android.R.string.ok) { _, _ -> }
            .setIcon(android.R.drawable.ic_dialog_alert).show()
    }

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(mainActivityJob + Dispatchers.IO)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = SearchFragment.bind(view)
        if (isNetworkConnected()) {
            retrieveData()
        } else {

            AlertDialog.Builder(activity).setTitle("No Internet Connection")
                .setMessage("Please check your internet connection and try again")
                .setPositiveButton(android.R.string.ok) { _, _ -> }
                .setIcon(android.R.drawable.ic_dialog_alert).show()
        }
        btn_search.setOnClickListener {
            retrieveData()
        }


    }


    private fun retrieveData() {
        if (viewBinding?.input_edit_text?.text.toString().isEmpty()) {
            Toast.makeText(activity, "Enter city Name", Toast.LENGTH_SHORT).show()

        }
        coroutineScope.launch(errorHandler) {
            //4
            val resultList = OpenWeather().getData(input_edit_text.text.toString())


            val temp = resultList.main.temp
            val temp1 = temp - 273
            val humidity = resultList.main.humidity
            val weatherDescription = resultList.weather[0].description
            val address = resultList.name + ", " + resultList.sys.country
            val wind = resultList.wind.speed


            /* Populating extracted data into our views */
            viewBinding?.address?.text = address.toString()
            viewBinding?.weather_description?.text = weatherDescription
            viewBinding?.temperature?.text = temp1.toInt().toString() + "°C"
            viewBinding?.humidity?.text = humidity.toString()
            viewBinding?.wind?.text = wind.toString()


        }


    }


    private fun isNetworkConnected(): Boolean {
        val connectivityManager =
            activity!!.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }


}