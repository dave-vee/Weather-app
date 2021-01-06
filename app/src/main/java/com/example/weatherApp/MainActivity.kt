package com.example.weatherApp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun search(view: View) {
        val myIntent = Intent(this, ActivitySearch::class.java)
        startActivity(myIntent)
    }


}