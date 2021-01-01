package com.example.weatherapp.recyclerview
//
//class DataAdapter {
//    <?xml version="1.0" encoding="utf-8"?>
//    <layout xmlns:android="http://schemas.android.com/apk/res/android"
//    xmlns:app="http://schemas.android.com/apk/res-auto">
//
//    <data>
//
//    <variable
//    name="city_name"
//    type="String" />
//
//    </data>
//
//    <RelativeLayout
//
//    android:layout_width="match_parent"
//    android:layout_height="match_parent"
//    android:background="@drawable/bg_gradient"
//    android:orientation="vertical"
//    android:padding="25dp">
//
//
//    <RelativeLayout
//    android:id="@+id/mainContainer"
//    android:layout_width="match_parent"
//    android:layout_height="match_parent"
//    android:visibility="visible">
//
//    <LinearLayout
//    android:id="@+id/addressContainer"
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content"
//    android:gravity="center"
//    android:orientation="vertical">
//
//    <TextView
//    android:id="@+id/address"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text="Nairobi , KE"
//    android:textSize="24dp" />
//
//
//    </LinearLayout>
//
//
//    <LinearLayout
//    android:id="@+id/overviewContainer"
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content"
//    android:layout_marginTop="100dp"
//    android:orientation="vertical">
//
//    <TextView
//    android:id="@+id/status"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:layout_gravity="center"
//    android:text="Clear Sky"
//    android:textSize="18dp" />
//
//    <TextView
//    android:id="@+id/temp"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:layout_gravity="center"
//    android:fontFamily="sans-serif-thin"
//    android:text="29°C"
//    android:textSize="90dp" />
//
//    <LinearLayout
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content"
//    android:gravity="center"
//    android:orientation="horizontal">
//
//    <TextView
//    android:id="@+id/temp_min"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text="" />
//
//    <Space
//    android:layout_width="50dp"
//    android:layout_height="wrap_content" />
//
//    <TextView
//    android:id="@+id/temp_max"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text="" />
//    </LinearLayout>
//
//    </LinearLayout>
//
//    <LinearLayout
//    android:id="@+id/detailsContainer"
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content"
//    android:layout_alignParentBottom="true"
//    android:orientation="vertical">
//
//    <LinearLayout
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content"
//    android:orientation="horizontal"
//    android:weightSum="3">
//
//    <LinearLayout
//    android:layout_width="0dp"
//    android:layout_height="wrap_content"
//    android:layout_weight="1"
//    android:background="#3CF1EBF1"
//    android:gravity="center"
//    android:orientation="vertical"
//    android:padding="8dp">
//
//    <ImageView
//    android:layout_width="25dp"
//    android:layout_height="25dp"
//    android:src="@drawable/sunrise"
//    app:tint="#FFFFFF" />
//
//    <Space
//    android:layout_width="wrap_content"
//    android:layout_height="5dp" />
//
//    <TextView
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text="Sunrise"
//    android:textSize="12dp" />
//
//    <TextView
//    android:id="@+id/sunrise"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text=""
//    android:textSize="14dp" />
//    </LinearLayout>
//
//    <Space
//    android:layout_width="10dp"
//    android:layout_height="wrap_content" />
//
//    <LinearLayout
//    android:layout_width="0dp"
//    android:layout_height="wrap_content"
//    android:layout_weight="1"
//    android:background="#3CF1EBF1"
//    android:gravity="center"
//    android:orientation="vertical"
//    android:padding="8dp">
//
//    <ImageView
//    android:layout_width="25dp"
//    android:layout_height="25dp"
//    android:src="@drawable/sunset"
//    app:tint="#FFFFFF" />
//
//    <Space
//    android:layout_width="wrap_content"
//    android:layout_height="5dp" />
//
//    <TextView
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text="Sunset"
//    android:textSize="12dp" />
//
//    <TextView
//    android:id="@+id/sunset"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text=""
//    android:textSize="14dp" />
//    </LinearLayout>
//
//    <Space
//    android:layout_width="10dp"
//    android:layout_height="wrap_content" />
//
//    <LinearLayout
//    android:layout_width="0dp"
//    android:layout_height="wrap_content"
//    android:layout_weight="1"
//    android:background="#3CF1EBF1"
//    android:gravity="center"
//    android:orientation="vertical"
//    android:padding="8dp">
//
//    <ImageView
//    android:layout_width="25dp"
//    android:layout_height="25dp"
//    android:src="@drawable/wind"
//    app:tint="#FFFFFF" />
//
//    <Space
//    android:layout_width="wrap_content"
//    android:layout_height="5dp" />
//
//    <TextView
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text="Wind"
//    android:textSize="12dp" />
//
//    <TextView
//    android:id="@+id/wind"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text=""
//    android:textSize="14dp" />
//    </LinearLayout>
//    </LinearLayout>
//
//    <Space
//    android:layout_width="wrap_content"
//    android:layout_height="10dp" />
//
//    <LinearLayout
//    android:layout_width="match_parent"
//    android:layout_height="wrap_content"
//    android:orientation="horizontal"
//    android:weightSum="3">
//
//    <LinearLayout
//    android:layout_width="0dp"
//    android:layout_height="wrap_content"
//    android:layout_weight="1"
//    android:background="#3CF1EBF1"
//    android:gravity="center"
//    android:orientation="vertical"
//    android:padding="8dp">
//
//    <ImageView
//    android:layout_width="25dp"
//    android:layout_height="25dp"
//    android:src="@drawable/pressure"
//    app:tint="#FFFFFF" />
//
//    <Space
//    android:layout_width="wrap_content"
//    android:layout_height="5dp" />
//
//    <TextView
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text="Pressure"
//    android:textSize="12dp" />
//
//    <TextView
//    android:id="@+id/pressure"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text=""
//    android:textSize="14dp" />
//    </LinearLayout>
//
//    <Space
//    android:layout_width="10dp"
//    android:layout_height="wrap_content" />
//
//    <LinearLayout
//    android:layout_width="0dp"
//    android:layout_height="wrap_content"
//    android:layout_weight="1"
//    android:background="#3CF1EBF1"
//    android:gravity="center"
//    android:orientation="vertical"
//    android:padding="8dp">
//
//    <ImageView
//    android:layout_width="25dp"
//    android:layout_height="25dp"
//    android:src="@drawable/humidity"
//    app:tint="#FFFFFF" />
//
//    <Space
//    android:layout_width="wrap_content"
//    android:layout_height="5dp" />
//
//    <TextView
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text="Humidity"
//    android:textSize="12dp" />
//
//    <TextView
//    android:id="@+id/humidity"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text=""
//    android:textSize="14dp" />
//    </LinearLayout>
//
//    <Space
//    android:layout_width="10dp"
//    android:layout_height="wrap_content" />
//
//    <LinearLayout
//    android:layout_width="0dp"
//    android:layout_height="wrap_content"
//    android:layout_weight="1"
//    android:background="#3CF1EBF1"
//    android:gravity="center"
//    android:orientation="vertical"
//    android:padding="8dp">
//
//    <ImageView
//    android:layout_width="25dp"
//    android:layout_height="25dp"
//    android:src="@drawable/info"
//    app:tint="#FFFFFF" />
//
//    <Space
//    android:layout_width="wrap_content"
//    android:layout_height="5dp" />
//
//    <TextView
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text=" "
//    android:textSize="12dp" />
//
//    <TextView
//    android:id="@+id/about"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:text=""
//    android:textSize="14dp" />
//    </LinearLayout>
//    </LinearLayout>
//
//    <LinearLayout
//    android:layout_width="match_parent"
//    android:layout_height="match_parent"
//    android:orientation="vertical">
//
//    <EditText
//    android:id="@+id/city_name"
//    android:layout_width="match_parent"
//    android:layout_height="match_parent"
//    android:hint="@string/enter_city_name_here"
//    android:text="@{city_name}" />
//
//    <Button
//
//    android:id="@+id/refresh"
//    android:layout_width="match_parent"
//    android:layout_height="match_parent"
//
//    android:text="@string/refresh" />
//
//
//    </LinearLayout>
//
//
//    </LinearLayout>
//
//
//    </RelativeLayout>
//
//    <ProgressBar
//    android:id="@+id/loader"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:layout_centerInParent="true"
//    android:visibility="gone" />
//
//    <TextView
//    android:id="@+id/errorText"
//    android:layout_width="wrap_content"
//    android:layout_height="wrap_content"
//    android:layout_centerInParent="true"
//    android:text="Something went wrong"
//    android:visibility="gone" />
//
//
//    </RelativeLayout>
//    </layout>
//
//}