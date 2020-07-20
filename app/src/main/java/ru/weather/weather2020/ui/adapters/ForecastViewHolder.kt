package ru.weather.weather2020.ui.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.weather.domain.models.CityModel
import ru.weather.weather2020.R
import ru.weather.weather2020.models.ForecastViewModel

class ForecastViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val icon = view.findViewById<ImageView>(R.id.ivIcon)
    private val description = view.findViewById<TextView>(R.id.tvForecastDescription)
    private val temp = view.findViewById<TextView>(R.id.tvForecastTemp)

    fun bind(model: ForecastViewModel) {
        temp.text = model.temp
        description.text = model.daysOfWeek
    }
}