package com.example.weatherapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContentView(R.layout.activity_main)


    }

    fun search(view: View) {
        val myIntent = Intent(this, ActivitySearch::class.java)
        startActivity(myIntent)
    }


}