package ru.weather.data.models

data class CityGsonModel(
    val weather: List<WeatherGsonModel>,
    val main: MainGsonModel,
    val wind: WindGsonModel,
    val dt: Long,
    val name: String
)