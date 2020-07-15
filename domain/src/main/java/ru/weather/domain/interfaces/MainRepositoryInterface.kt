package ru.weather.domain.interfaces

import ru.weather.domain.models.CityModel
import ru.weather.domain.models.ForeCastModel

interface MainRepositoryInterface {
    suspend fun getCityData(cityName: String): CityModel
    suspend fun getForeCast(cityName: String): ForeCastModel
}