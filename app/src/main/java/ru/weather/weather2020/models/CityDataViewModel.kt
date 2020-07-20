package ru.weather.weather2020.models

data class CityDataViewModel(
    val cityName: String,
    val weather: String,
    val tempMinMax: String,
    val icon: String,
    val temp: String,
    val pressure: String,
    val humidity: String,
    val description: String,
    val windSpeed: String
)