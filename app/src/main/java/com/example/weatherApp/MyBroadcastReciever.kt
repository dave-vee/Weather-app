package com.example.weatherApp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReciever : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isLow = intent?.getBooleanExtra("state", false) ?: return
        if (isLow) {
            Toast.makeText(context, "Battery low", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Battery Charge above Normal", Toast.LENGTH_LONG).show()
        }
    }
}