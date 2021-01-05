package com.example.weatherApp.recyclerview

//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.weatherapp.R
//import com.example.weatherapp.models.Response
//import kotlinx.android.synthetic.main.item_view_holder.view.*
//
//
//class WeatherAdapter(private val list: List<Response>) :
//    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {
//
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        fun bindWeatherData(data: Response) {
//            with(data) {
//                itemView.tv_address.text = name.toString()
//                itemView.tv_weather_description.text = weather.toString()
//                itemView.tv_temp.text = main.temp.toString()
//                itemView.tv_Humidity.text = main.humidity.toString()
//                itemView.tv_wind.text = wind.toString()
//
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAdapter.ViewHolder {
//        val view =
//            LayoutInflater.from(parent.context)
//                .inflate(R.layout.item_view_holder, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: WeatherAdapter.ViewHolder, position: Int) {
//        Log.e("TAG", "onBindViewHolder:$position ")
//        holder.bindWeatherData(list[position])
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//}
//
