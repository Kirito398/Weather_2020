package ru.weather.weather2020.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.weather.weather2020.R
import ru.weather.weather2020.models.ForecastViewModel

class ForecastAdapter(private var forecastData: MutableList<ForecastViewModel>) : RecyclerView.Adapter<ForecastViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)
        return ForecastViewHolder(view)
    }

    override fun getItemCount() = forecastData.size

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(forecastData[position])
    }

    fun updateData(data: List<ForecastViewModel>) {
        this.forecastData.clear()
        this.forecastData.addAll(data)
        this.notifyDataSetChanged()
    }
}