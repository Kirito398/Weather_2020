package ru.weather.domain.models

data class MainModel(
    val temp: Float,
    val pressure: Float,
    val humidity: Int,
    val tempMin: Float,
    val tempMax: Float
)