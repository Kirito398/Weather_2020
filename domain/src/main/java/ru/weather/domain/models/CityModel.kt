package ru.weather.domain.models

import java.util.*

data class CityModel(
    val weather: List<WeatherModel>,
    val main: MainModel,
    val wind: WindModel,
    val dt: Long,
    val name: String
) {
    fun getData(): Calendar {
        val date = Calendar.getInstance()
        date.timeInMillis = dt*1000
        return date
    }
}