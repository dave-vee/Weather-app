package com.example.weatherApp.ui

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherApp.MyBroadcastReciever
import com.example.weatherApp.R


class MainActivity : AppCompatActivity() {


    lateinit var reciever: MyBroadcastReciever
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reciever = MyBroadcastReciever()
        IntentFilter(Intent.ACTION_BATTERY_LOW).also {
            registerReceiver(reciever, it)
        }
    }

    fun search(view: View) {
        val myIntent = Intent(this, ActivitySearch::class.java)
        startActivity(myIntent)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(reciever)
    }

}