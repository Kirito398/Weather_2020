package ru.weather.weather2020.ui.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.weather.weather2020.R
import ru.weather.weather2020.models.ForecastViewModel

class ForecastViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val icon = view.findViewById<ImageView>(R.id.ivIcon)
    private val description = view.findViewById<TextView>(R.id.tvForecastDescription)
    private val temp = view.findViewById<TextView>(R.id.tvForecastTemp)

    fun bind(model: ForecastViewModel) {
        temp.text = model.temp
        description.text = model.daysOfWeek

        Picasso.get()
            .load(model.icon)
            .error(R.mipmap.ic_launcher_round)
            .into(icon)
    }
}