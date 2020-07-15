package ru.weather.domain.models

data class WeatherModel(
    val main: String,
    val description: String,
    val icon: String
)